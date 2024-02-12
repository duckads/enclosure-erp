package kr.co.shield.service.inf;

import kr.co.shield.dto.MemberDto;
import kr.co.shield.dto.ProductDto;

import java.util.List;
import java.util.Map;

public interface ProductService {
	
	public List<ProductDto> findAll(MemberDto user, Map<String, Object> props);
	
	public ProductDto findOne(MemberDto user, Map<String, Object> props);
	
	public String create(MemberDto user, Map<String, Object> props);
	
	public String update(MemberDto user, Map<String, Object> props);
	
	public String delete(MemberDto user, Map<String, Object> props);
	
}
