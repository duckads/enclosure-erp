package kr.co.shield.service.inf;

import kr.co.shield.dto.MemberDto;
import kr.co.shield.dto.QnaDto;

import java.util.List;
import java.util.Map;

public interface QnaService {
	
	public List<QnaDto> findAll(MemberDto user, Map<String, Object> props);
	
	public QnaDto findOne(MemberDto user, Map<String, Object> props);
	
	public String create(MemberDto user, Map<String, Object> props);
	
	public String update(MemberDto user, Map<String, Object> props);
	
	public String delete(MemberDto user, Map<String, Object> props);
	
}
