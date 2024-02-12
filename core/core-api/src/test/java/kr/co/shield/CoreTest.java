package kr.co.shield;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kr.co.shield.common.CodeManager;
import kr.co.shield.domain.*;
import kr.co.shield.dto.*;
import kr.co.shield.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
public class CoreTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberRoleRepository memberRoleRepository;

    @Autowired
    ShEstimateRepository shEstimateRepository;

    @Autowired
    ShEstimateTableRepository shEstimateTableRepository;

    @Autowired
    ShEstimateDtlTableRepository shEstimateDtlTableRepository;

    @Autowired
    EstimateRepository estimateRepository;

    @Autowired
    EstimateDtlRepository estimateDtlRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ProducerRepository producerRepository;


    @Test
    void insertCompanyAndMember() {
        // 고객 등록
        Company company = new Company();
        company.setCompanyNm("실드 주식회사");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("phone", "02-2269-1233");
        jsonObject.addProperty("fax", "02-2285-1236");
        jsonObject.addProperty("addresss", "경기도 양주시 백석읍 중앙로 287");
        jsonObject.addProperty("sector", "제조업,건설업 외");
        jsonObject.addProperty("type", "건설기자재,방음벽 외");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(jsonObject);
        company.setCompanyOption(jsonStr);
        company.setRegDt(new Date());
        company.setActSt(CodeManager.code("ACTIVE_ST_Y"));
        company.setSeq(1);


        //한 회사에 공급자 여러 개인 경우
        Producer producer = new Producer();
        producer.setSeq(1);
        producer.setProducerNm("실드 주식회사");
        producer.setProducerOption(jsonStr);
        producer.setRegDt(new Date());
        producer.setActSt(CodeManager.code("ACTIVE_ST_Y"));
        producer.setCompanySeq(company.getSeq());
    }


    @Test
    void insertDataEstimate() {
        List<LegacyEstimate> legacyEstimates = shEstimateRepository.findAll();
        Gson gson = new Gson();

        for (LegacyEstimate legacyEstimate : legacyEstimates) {

            Estimate estimate = new Estimate();
            estimate.setEstimateNm(legacyEstimate.getEstimateTitle() != null ? legacyEstimate.getEstimateTitle() : "");
            estimate.setEstimateNote(legacyEstimate.getEstimateTextarea());
            estimate.setEstimateCode(legacyEstimate.getEstimateCode());
            estimate.setMemberSeq(2);


            BusinessDealDTO businessDealDTO = BusinessDealDTO.builder()
                    .name(legacyEstimate.getEstimateBuyerComName())
                    .phone(legacyEstimate.getEstimateBuyerComPhone())
                    .fax(legacyEstimate.getEstimateBuyerComFax())
                    .email(legacyEstimate.getEstimateBuyerComEmail())
                    .type(CodeManager.code("INVOICE_FORM_TP_ESTIMATE"))
                    .build();

            BusinessDealMgrDto businessDealMgrDto = BusinessDealMgrDto.builder().
                    name(legacyEstimate.getEstimateBuyerName()).
                    email(legacyEstimate.getEstimateBuyerEmail()).
                    phone(legacyEstimate.getEstimateBuyerPhone()).
                    type(CodeManager.code("INVOICE_FORM_TP_ESTIMATE")).
                    build();

            EstimateMgrDto estimateMgrDto = EstimateMgrDto.builder().
                    name(legacyEstimate.getEstimateManager()).
                    phone(legacyEstimate.getEstimateManagerPhone()).
                    email(legacyEstimate.getEstimateManagerEmail()).
                    build();

            estimate.setCustomerCom(businessDealDTO);
            estimate.setCustomerMgr(businessDealMgrDto);
            estimate.setEstimateMgr(estimateMgrDto);

            if (legacyEstimate.getEstimateType().equals("DIL")) { //납품인 경우
                estimate.setEstimateTp(CodeManager.code("ESTIMATE_TP_DELIVERY"));
                Optional<List<LegacyEstimateTable>> legacyEstimateTable = shEstimateTableRepository.findByEstimateCode(legacyEstimate.getEstimateCode());
                for (LegacyEstimateTable estimateTable : legacyEstimateTable.get()) {
                    EstimateDtl estimateDtl = new EstimateDtl();
                    estimateDtl.setProductSize(estimateTable.getEstimateTableStandard());
                    estimateDtl.setProductQuantity(estimateTable.getEstimateTableQuantity());
                    estimateDtl.setProductUnit(estimateTable.getEstimateTableUnit());
                    estimateDtl.setProductPrice(estimateTable.getEstimateTableUnitPrice() != null ? estimateTable.getEstimateTableUnitPrice() : 0);
                    estimateDtl.setProductSupplyPrice(estimateTable.getEstimateTableSupplyPrice() != null ? estimateTable.getEstimateTableSupplyPrice() : 0);
                    estimateDtl.setActSt(CodeManager.code("ACTIVE_ST_Y"));
                    estimateDtl.setMaterialCosts(null); // 재료비
                    estimateDtl.setLaborCosts(null); // 노무비
                    estimateDtl.setOverheadCosts(null); // 경비비
                    estimateDtl.setEstimate(estimate);
                    estimateDtl.setRegDt(new Date());
                    estimateDtl.setUpdDt(new Date());
                    estimateDtl.setCompanySeq(1);
                    estimateDtlRepository.save(estimateDtl);
                }

            } else { //공사인경우
                estimate.setEstimateTp(CodeManager.code("ESTIMATE_TP_CONSTRUCTION"));
                Optional<List<LegacyEstimateTable>> legacyEstimateTable = shEstimateTableRepository.findByEstimateCode(legacyEstimate.getEstimateCode());
                for (LegacyEstimateTable estimateTable : legacyEstimateTable.get()) {
                    EstimateDtl estimateDtl = new EstimateDtl();

                    List<ProductFormDto> materialCosts = new ArrayList<>();
                    List<ProductFormDto> laborCosts = new ArrayList<>();
                    List<ProductFormDto> overheadCosts = new ArrayList<>();
                    List<LegacyEstimateDtlTable> legacyEstimateDtlTables = shEstimateDtlTableRepository.findByEstimateCode(legacyEstimate.getEstimateCode());

                    assert legacyEstimateDtlTables != null;
                    for (LegacyEstimateDtlTable legacyEstimateDtlTable : legacyEstimateDtlTables) {
                        if (legacyEstimateDtlTable.getEstimateDtlKindsCode() != null) {
                            ProductFormDto build = ProductFormDto.builder().productNm(legacyEstimateDtlTable.getEstimateDtlTableName())
                                    .productSize(legacyEstimateDtlTable.getEstimateDtlTableStandard())
                                    .productQuantity(legacyEstimateDtlTable.getEstimateDtlTableQuantity())
                                    .productUnit(legacyEstimateDtlTable.getEstimateDtlTableUnit())
                                    .productPrice(legacyEstimateDtlTable.getEstimateDtlTableUnitPrice())
                                    .productSupplyPrice(legacyEstimateDtlTable.getEstimateDtlTableSupplyPrice())
                                    .productTp(legacyEstimateDtlTable.getEstimateDtlTableCode())
                                    .productNote(legacyEstimateDtlTable.getEstimateDtlTableNote()).build();

                            switch (legacyEstimateDtlTable.getEstimateDtlKindsCode()) {
                                case "jaeryo" -> {
                                    System.out.println("재료인 경우");
                                    materialCosts.add(build);
                                }
                                case "nomoo" -> {
                                    System.out.println("노무비");
                                    laborCosts.add(build);
                                }
                                case "gyungbi" -> {
                                    System.out.println("경비비");
                                    overheadCosts.add(build);
                                }
                            }
                        }
                    }

                    estimateDtl.setProductSize(estimateTable.getEstimateTableStandard());
                    estimateDtl.setProductQuantity(estimateTable.getEstimateTableQuantity());
                    estimateDtl.setProductUnit(estimateTable.getEstimateTableUnit());
                    estimateDtl.setProductPrice(estimateTable.getEstimateTableUnitPrice() != null ? estimateTable.getEstimateTableUnitPrice() : 0);
                    estimateDtl.setProductSupplyPrice(estimateTable.getEstimateTableSupplyPrice() != null ? estimateTable.getEstimateTableSupplyPrice() : 0);
                    estimateDtl.setActSt(CodeManager.code("ACTIVE_ST_Y"));
                    estimateDtl.setMaterialCosts(materialCosts); // 재료비
                    estimateDtl.setLaborCosts(laborCosts); // 노무비
                    estimateDtl.setOverheadCosts(overheadCosts); // 경비비
                    estimateDtl.setEstimate(estimate);
                    estimateDtl.setRegDt(new Date());
                    estimateDtl.setUpdDt(new Date());
                    estimateDtl.setCompanySeq(1);
                    estimateDtlRepository.save(estimateDtl);
                }
            }

            estimate.setActSt(CodeManager.code("ACTIVE_ST_Y"));
            estimate.setRegDt(new Date());
            estimate.setUpdDt(new Date());

            //Json key, value 추가
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("expir_dt", legacyEstimate.getEstimateExpri());
            jsonObject.addProperty("start_dt", legacyEstimate.getEstimateStartdt());
            jsonObject.addProperty("payment_tp", legacyEstimate.getEstimatePayment());
            String jsonStr = gson.toJson(jsonObject);

            estimate.setEstimateOption(jsonStr);
            estimate.setCompanySeq(1);
            estimate.setProducerSeq(1);
            estimateRepository.save(estimate);
        }
    }
}
