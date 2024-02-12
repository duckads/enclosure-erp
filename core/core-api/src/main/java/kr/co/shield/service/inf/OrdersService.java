package kr.co.shield.service.inf;

import kr.co.shield.dto.MemberDto;
import kr.co.shield.dto.OrdersDto;
import kr.co.shield.dto.OrderDto2;

import java.util.List;
import java.util.Map;

public interface OrdersService {
	
	public List<OrdersDto> findAll(MemberDto user, Map<String, Object> props);
	
	public OrdersDto findOne(MemberDto user, Map<String, Object> props);
	
	public String create(MemberDto user, Map<String, Object> props);
	
	public String update(MemberDto user, Map<String, Object> props);
	
	public String delete(MemberDto user, Map<String, Object> props);

	/* Additional */
	
	public Map<String, Object> preview(MemberDto user, OrderDto2 orderDto);
	
}
