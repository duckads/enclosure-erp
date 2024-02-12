package kr.co.shield.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class IssueDto {
	
	private String ssn;
	private String zip;
	private String addr1;
	private String addr2;
	private String buyer;
	private String phone;
	private String email;
	
	private String issueName;
	private String issueCeoName;
	private String issueSsn;
	private String issueAddr;
	private String issueManagerName;
	private String issueManagerPhone;
	private String issueManagerEmail;
	private String issueBizType;
	private String issueBizName;
	private String issueBizPhoto;
	private String issueBankPhoto;
	
}
