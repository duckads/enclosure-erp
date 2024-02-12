package kr.co.shield.service.inf;

import kr.co.shield.dto.MemberDto;
import kr.co.shield.dto.NoticeDto;

import java.util.List;
import java.util.Map;

public interface NoticeService {
	
	public List<NoticeDto> findAll(MemberDto user, Map<String, Object> props);
	
	public NoticeDto findOne(MemberDto user, Map<String, Object> props);
	
	public String create(MemberDto user, Map<String, Object> props);
	
	public String update(MemberDto user, Map<String, Object> props);
	
	public String delete(MemberDto user, Map<String, Object> props);
	
	/* Additional */
	
	public String send(String templateTag, String recipient, Map<String, Object> param);
	
}
