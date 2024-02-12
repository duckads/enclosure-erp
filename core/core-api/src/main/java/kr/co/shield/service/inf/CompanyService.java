package kr.co.shield.service.inf;

import kr.co.shield.dto.MemberDto;
import kr.co.shield.dto.CompanyDto;
import kr.co.shield.dto.IssueDto;

import java.util.List;
import java.util.Map;

public interface CompanyService {
	
	public List<CompanyDto> findAll(MemberDto user, Map<String, Object> props);
	
	public CompanyDto findOne(MemberDto user, Map<String, Object> props);
	
	public String create(MemberDto user, Map<String, Object> props);
	
	public String update(MemberDto user, Map<String, Object> props);
	
	public String update(MemberDto user, IssueDto issueDto);
	
	public String delete(MemberDto user, Map<String, Object> props);
	
}
