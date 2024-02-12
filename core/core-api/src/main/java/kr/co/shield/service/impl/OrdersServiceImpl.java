package kr.co.shield.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import kr.co.shield.common.CodeManager;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.dto.*;
import kr.co.shield.repository.OrdersRepository;
import kr.co.shield.domain.Orders;
import kr.co.shield.ext.Option;
import kr.co.shield.dto.OrderDto2.Product;
import kr.co.shield.service.inf.OrdersService;
import kr.co.shield.util.JpaUtil;
import kr.co.shield.utility.DateUtils;
import kr.co.shield.utility.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@SuppressWarnings({ "unchecked", "unused" })
public class OrdersServiceImpl implements OrdersService {
	
	@PersistenceContext
	private final EntityManager entityManager;
	
	private final OrdersRepository ordersRepository;
	
	private final MessageSource messageSource;
	
	/**
	 * RestApi
	 */
	@Override
	@Transactional
	public List<OrdersDto> findAll(MemberDto user, Map<String, Object> props) {
		List<OrdersDto> rtnList = null;
		
		CompanyDto tknAgency = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknAdminSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		String userRole = StringUtils.getString(user.getRoles());
		
		/* implementation */
		
		Integer agencySeq = tknAgency.getSeq();
		
		String adminSeq = StringUtils.getString(props.get("adminSeq"));
		String orderSt = StringUtils.getString(props.get("orderSt"));
		if (orderSt.isBlank()) {
			orderSt = CodeManager.code("ORDER_ST_READY");
		}
		String payTp = StringUtils.getString(props.get("payTp"));
		String psDate = StringUtils.getString(props.get("psDate")) + " 00:00:00";
		String peDate = StringUtils.getString(props.get("peDate")) + " 23:59:59";
		
		Specification<Orders> where = JpaUtil.in(Orders.class, "orderSt", Arrays.asList(orderSt.split(",")));
		where = where.and(JpaUtil.in(Orders.class, "payTp", Arrays.asList(payTp.split(","))));
		if (!adminSeq.isBlank()) {
			where = where.and(JpaUtil.in(Orders.class, "adminSeq", Arrays.asList(adminSeq.split(","))));
		}
		if (!StringUtils.getString(props.get("psDate")).isBlank()) {
			where = where.and(JpaUtil.between(Orders.class, "regDt", DateUtils.parse(psDate, DateUtils.DATE_FORMAT_FULL), DateUtils.parse(peDate, DateUtils.DATE_FORMAT_FULL)));
		}
		if ((userRole.indexOf("ROLE_SUPER") > -1 || userRole.indexOf("ROLE_ADMIN") > -1) && props.containsKey("agencySeq")) {
			String agencySeqs = StringUtils.getString(props.get("agencySeq"));
			if (!agencySeqs.isBlank()) {
				where = where.and(JpaUtil.in(Orders.class, "agencySeq", Arrays.asList(agencySeqs.split(","))));
			}
		} else {
			where = where.and(JpaUtil.equal(Orders.class, "agencySeq", agencySeq));
		}
		
		Sort sort = Sort.by(Direction.DESC, "regDt");
		
		List<Orders> orders = this.ordersRepository.findAll(where, sort);
		if (orders.isEmpty()) {
			rtnList = Collections.emptyList();
		} else {
			rtnList = orders.stream()
					.map(e -> e.getDto())
					.collect(Collectors.toList());
		}
		
		/* implementation */
		
		return rtnList;
	}
	
	@Override
	@Transactional
	public OrdersDto findOne(MemberDto user, Map<String, Object> props) {
		OrdersDto rtnObj = null;
		
		CompanyDto tknAgency = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknAdminSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		/* implementation */
		
		
		
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
		
		String orderNo = StringUtils.getString(props.get("id"));
		
		Optional<Orders> optOrders = this.ordersRepository.findById(orderNo);
		
		Orders orders = null;
		if (optOrders.isPresent()) {
			orders = optOrders.get();
		}
		
		orders.setOrderSt(CodeManager.code("ORDER_ST_DELETE"));
		orders.setUpdDt(new Date(System.currentTimeMillis()));
		
		orders = this.entityManager.merge(orders);
		
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
	
	/* Additional */
	
	@Override
	@Transactional
	public Map<String, Object> preview(MemberDto user, OrderDto2 orderDto) {
		Map<String, Object> rtnMap = new HashMap<>();
		
		CompanyDto tknAgency = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		
		// [플랜|추가]
		String paymentType = orderDto.getPaymentType();
		
		// [베이식|스탠다드]
		String servicePlan = orderDto.getServicePlan();
		// 개월
		String servicePeriod = orderDto.getServicePeriod();
		
		// 주문 상품
		List<Product> products = orderDto.getProducts();
		
		Map<String, Object> contract = (Map<String, Object>)tknAgency.getOption(Option.AGENCY_contract);
		
		// 플랜 결제
//		if () {
//			// 
//		}
//		
//		if () {
//			
//		}
//		
//		
//		// 추가 결제
//		
//		
//		
//		rtnMap.put("usage", usage);
//		rtnMap.put("summary", summary);
//		rtnMap.put("contract", contract);
		
		return rtnMap;
	}
	
}
