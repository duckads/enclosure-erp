package kr.co.shield.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import kr.co.shield.common.CodeManager;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.repository.ProductRepository;
import kr.co.shield.domain.Product;
import kr.co.shield.dto.MemberDto;
import kr.co.shield.dto.CompanyDto;
import kr.co.shield.dto.ProductDto;
import kr.co.shield.service.inf.ProductService;
import kr.co.shield.util.JpaUtil;
import kr.co.shield.utility.NumberUtils;
import kr.co.shield.utility.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@SuppressWarnings({ "unchecked", "unused" })
public class ProductServiceImpl implements ProductService {
	
	@PersistenceContext
	private final EntityManager entityManager;
	
	private final ProductRepository productRepository;
	
	private final MessageSource messageSource;
	
	/**
	 * RestApi
	 */
	@Override
	@Transactional
	public List<ProductDto> findAll(MemberDto user, Map<String, Object> props) {
		List<ProductDto> rtnList = null;
		
		CompanyDto tknAgency = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknAdminSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		/* implementation */
		
		String productTp = StringUtils.getString(props.get("productTp"));
		
		Specification<Product> where = JpaUtil.equal(Product.class, "actSt", CodeManager.code("ACTIVE_ST_Y"));
		if (!productTp.isBlank()) {
			where = where.and(JpaUtil.equal(Product.class, "productTp", productTp));
		}
		
		List<Product> products = this.productRepository.findAll(where);
		if (products.isEmpty()) {
			rtnList = Collections.emptyList();
		} else {
			rtnList = products.stream()
					.map(e -> e.getDto())
					.collect(Collectors.toList());
		}
		
		/* implementation */
		
		return rtnList;
	}
	
	@Override
	@Transactional
	public ProductDto findOne(MemberDto user, Map<String, Object> props) {
		ProductDto rtnObj = null;
		
		CompanyDto tknAgency = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknAdminSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		/* implementation */
		
		Integer id = NumberUtils.getNumber(props.get("id"));
		Optional<Product> optProduct = this.productRepository.findById(id);
		if (optProduct.isPresent()) {
			rtnObj = optProduct.get().getDto();
		}
		
		/* implementation */
		
		return rtnObj;
	}
	
	@Override
	@Transactional
	public String create(MemberDto user, Map<String, Object> props) {
		String rtnMsg = ShieldProperty.RK_MSG_SUCCESS;
		
		CompanyDto tknAgency = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknAdminSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		/* implementation */
		
		
		
		/* implementation */
		
		return rtnMsg;
	}
	
	@Override
	@Transactional
	public String update(MemberDto user, Map<String, Object> props) {
		String rtnMsg = ShieldProperty.RK_MSG_SUCCESS;
		
		CompanyDto tknAgency = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknAdminSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		/* implementation */
		
		
		
		/* implementation */
		
		return rtnMsg;
	}
	
	@Override
	@Transactional
	public String delete(MemberDto user, Map<String, Object> props) {
		String rtnMsg = ShieldProperty.RK_MSG_SUCCESS;
		
		CompanyDto tknAgency = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknAdminSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		/* implementation */
		
		
		
		/* implementation */
		
		return rtnMsg;
	}
	
}
