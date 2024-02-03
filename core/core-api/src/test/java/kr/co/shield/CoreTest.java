package kr.co.shield;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kr.co.shield.domain.*;
import kr.co.shield.dto.MemberDto;
import kr.co.shield.dto.RoleDto;
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
            estimate.setActSt("201001");
            estimate.setRegDt(new Date());
            estimate.setUpdDt(new Date());

            // Json key, value 추가
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("expir_dt", legacyEstimate.getEstimateExpri());
            jsonObject.addProperty("start_dt", legacyEstimate.getEstimateStartdt());
            jsonObject.addProperty("payment_tp", "선금");

            // JsonObject를 Json 문자열로 변환
            String jsonStr = gson.toJson(jsonObject);

            // 생성된 Json 문자열 출력
            estimate.setEstimateOption(jsonStr);
            estimateRepository.save(estimate);

            Optional<List<LegacyEstimateTable>> legacyEstimateTable = shEstimateTableRepository.findByEstimateCode(legacyEstimate.getEstimateCode());

            for (LegacyEstimateTable estimateTable : legacyEstimateTable.get()) {
                System.out.println(estimateTable.getEstimateCode());
                System.out.println(estimateTable.getEstimateTableCode());

                EstimateDtl estimateDtl = new EstimateDtl();
                estimateDtl.setProductSize(estimateTable.getEstimateTableStandard());
                estimateDtl.setProductQuantity(estimateTable.getEstimateTableQuantity());
                estimateDtl.setProductUnit(estimateTable.getEstimateTableUnit());
                estimateDtl.setProductPrice(estimateTable.getEstimateTableUnitPrice() != null?estimateTable.getEstimateTableUnitPrice():0);
                estimateDtl.setProductSupplyPrice(new Long(estimateTable.getEstimateTableSupplyPrice()!= null?estimateTable.getEstimateTableSupplyPrice():0));


                List<LegacyEstimateDtlTable> legacyEstimateDtlTables = shEstimateDtlTableRepository.findByEstimateCode(legacyEstimate.getEstimateCode());

                if (legacyEstimateDtlTables != null) {
                    System.out.println("널이 아닙니다.");
                } else {

                }

                List<String> jaeryList = new ArrayList<>();
                List<String> nommonList = new ArrayList<>();
                List<String> gyungbiList = new ArrayList<>();

                assert legacyEstimateDtlTables != null;
                for (LegacyEstimateDtlTable legacyEstimateDtlTable : legacyEstimateDtlTables) {
                    System.out.println("안성재");
                    if (legacyEstimateDtlTable.getEstimateDtlKindsCode() != null) {
                        if (legacyEstimateDtlTable.getEstimateDtlKindsCode().equals("jaeryo")) {
                            System.out.println("안성재1");
                            JsonObject jaeryoJsonObject = new JsonObject();
                            jaeryoJsonObject.addProperty("name", legacyEstimateDtlTable.getEstimateDtlTableName());
                            jaeryoJsonObject.addProperty("size", legacyEstimateDtlTable.getEstimateDtlTableStandard());
                            jaeryoJsonObject.addProperty("quantity", legacyEstimateDtlTable.getEstimateDtlTableQuantity());
                            jaeryoJsonObject.addProperty("unit", legacyEstimateDtlTable.getEstimateDtlTableUnit());
                            jaeryoJsonObject.addProperty("price", legacyEstimateDtlTable.getEstimateDtlTableUnitPrice());
                            jaeryoJsonObject.addProperty("supply_price", legacyEstimateDtlTable.getEstimateDtlTableSupplyPrice());
                            jaeryoJsonObject.addProperty("type", legacyEstimateDtlTable.getEstimateDtlTableCode());
                            jaeryoJsonObject.addProperty("note", legacyEstimateDtlTable.getEstimateDtlTableNote());

                            jaeryList.add(gson.toJson(jaeryoJsonObject));

                        } else if (legacyEstimateDtlTable.getEstimateDtlKindsCode().equals("nomoo")) {
                            System.out.println("안성재2");
                            JsonObject nomooJsonObject = new JsonObject();
                            nomooJsonObject.addProperty("name", legacyEstimateDtlTable.getEstimateDtlTableName());
                            nomooJsonObject.addProperty("size", legacyEstimateDtlTable.getEstimateDtlTableStandard());
                            nomooJsonObject.addProperty("quantity", legacyEstimateDtlTable.getEstimateDtlTableQuantity());
                            nomooJsonObject.addProperty("unit", legacyEstimateDtlTable.getEstimateDtlTableUnit());
                            nomooJsonObject.addProperty("price", legacyEstimateDtlTable.getEstimateDtlTableUnitPrice());
                            nomooJsonObject.addProperty("supply_price", legacyEstimateDtlTable.getEstimateDtlTableSupplyPrice());
                            nomooJsonObject.addProperty("type", legacyEstimateDtlTable.getEstimateDtlTableCode());
                            nomooJsonObject.addProperty("note", legacyEstimateDtlTable.getEstimateDtlTableNote());

                            nommonList.add(gson.toJson(nomooJsonObject));

                        } else if ((legacyEstimateDtlTable.getEstimateDtlKindsCode().equals("gyungbi"))) {
                            System.out.println("안성재3");
                            JsonObject gyungbiJsonObject = new JsonObject();
                            gyungbiJsonObject.addProperty("name", legacyEstimateDtlTable.getEstimateDtlTableName());
                            gyungbiJsonObject.addProperty("size", legacyEstimateDtlTable.getEstimateDtlTableStandard());
                            gyungbiJsonObject.addProperty("quantity", legacyEstimateDtlTable.getEstimateDtlTableQuantity());
                            gyungbiJsonObject.addProperty("unit", legacyEstimateDtlTable.getEstimateDtlTableUnit());
                            gyungbiJsonObject.addProperty("price", legacyEstimateDtlTable.getEstimateDtlTableUnitPrice());
                            gyungbiJsonObject.addProperty("supply_price", legacyEstimateDtlTable.getEstimateDtlTableSupplyPrice());
                            gyungbiJsonObject.addProperty("type", legacyEstimateDtlTable.getEstimateDtlTableCode());
                            gyungbiJsonObject.addProperty("note", legacyEstimateDtlTable.getEstimateDtlTableNote());

                            gyungbiList.add(gson.toJson(gyungbiJsonObject));

                        }
                    }
                }

                estimateDtl.setActSt("201001");
                estimateDtl.setProductTp("");
                estimateDtl.setMaterialCost(jaeryList.toString()); // 재료비
                estimateDtl.setLaborCost(nommonList.toString()); // 노무비
                estimateDtl.setOverheadCost(gyungbiList.toString()); // 경비비
                estimateDtl.setEstimate(estimate);
                estimateDtl.setRegDt(new Date());
                estimateDtl.setUpdDt(new Date());
                estimateDtlRepository.save(estimateDtl);
            }

        }
    }


    @Test
    void hello() {
        System.out.println("wow");
        Optional<List<LegacyEstimateTable>> byEstimateCode = shEstimateTableRepository.findByEstimateCode("2203A005");
        List<LegacyEstimateDtlTable> legacyEstimateDtlTables = shEstimateDtlTableRepository.findByEstimateCode("2203A029");
        System.out.println(legacyEstimateDtlTables);
        for (LegacyEstimateDtlTable legacyEstimateDtlTable : legacyEstimateDtlTables) {
            System.out.println(legacyEstimateDtlTable.getEstimateDtlKindsCode());
        }

    }


    void testOne() {
        List<LegacyEstimate> legacyEstimates = shEstimateRepository.findAll();
//        List<LegacyEstimateTable> legacyEstimateTables = shEstimateTableRepository.findAll();
//        List<LegacyEstimateDtlTable> legacyEstimateDtlTables = shEstimateDtlTableRepository.findAll();

        System.out.println(legacyEstimates);
//        System.out.println(legacyEstimateTables);
//        System.out.println(legacyEstimateDtlTables);
    }


//    @Test
//    void setData() {
//
//        Member member = new Member();
//        member.setMemberNm("안성재");
//        member.setMemberPw("쓰마트0)");
//        member.setMemberId("asj");
//        member.setMemberOption("");
//        member.setRegDt(new Date());
//        member.setUpdDt(new Date());
//        member.setActSt("201001");
//        memberRepository.save(member);
//
//        MemberRole memberRole = new MemberRole();
//        memberRole.setMemberSeq(member.getSeq());
//        memberRole.setRoleSeq(3);
//
//
//        memberRoleRepository.save(memberRole);
//    }
//
//    @Test
//    void setData2() {
//
//        Optional<Member> member = memberRepository.findByMemberId("asj");
//
//        MemberRole memberRole = new MemberRole();
//        memberRole.setMemberSeq(1);
//        memberRole.setRoleSeq(3);
//
//        memberRoleRepository.save(memberRole);
//    }
}
