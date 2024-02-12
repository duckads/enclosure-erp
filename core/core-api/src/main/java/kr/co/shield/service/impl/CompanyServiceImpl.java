package kr.co.shield.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.repository.CompanyRepository;
import kr.co.shield.domain.Company;
import kr.co.shield.dto.MemberDto;
import kr.co.shield.dto.CompanyDto;
import kr.co.shield.common.exception.BadRequestException;
import kr.co.shield.dto.IssueDto;
import kr.co.shield.ext.Option;
import kr.co.shield.service.inf.CompanyService;
import kr.co.shield.utility.NumberUtils;
import kr.co.shield.utility.StringUtils;
import kr.co.shield.domain.Company;
import kr.co.shield.service.inf.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@SuppressWarnings({ "unchecked", "unused" })
public class CompanyServiceImpl implements CompanyService {
	
	@PersistenceContext
	private final EntityManager entityManager;
	
	private final CompanyRepository companyRepository;
	
	private final MessageSource messageSource;
	
	/**
	 * RestApi
	 */
	@Override
	@Transactional
	public List<CompanyDto> findAll(MemberDto user, Map<String, Object> props) {
		List<CompanyDto> rtnList = null;
		
		CompanyDto tknCompany = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknAdminSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		/* implementation */
		
		List<Company> agencies = this.companyRepository.findAll();
		if (agencies.isEmpty()) {
			rtnList = Collections.emptyList();
		} else {
			rtnList = agencies.stream()
					.map(e -> e.getDto())
					.collect(Collectors.toList());
		}
		
		/* implementation */
		
		return rtnList;
	}
	
	@Override
	@Transactional
	public CompanyDto findOne(MemberDto user, Map<String, Object> props) {
		CompanyDto rtnObj = null;
		
		CompanyDto tknCompany = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknAdminSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		/* implementation */
		
		int agencySeq = user.getCompanySeq();
		
		Optional<Company> optCompany = this.companyRepository.findById(agencySeq);
		if (optCompany.isPresent()) {
			rtnObj = optCompany.get().getDto();
		}
		
		/* implementation */
		
		return rtnObj;
	}
	
	@Override
	@Transactional
	public String create(MemberDto user, Map<String, Object> props) {
		String rtnMsg = ShieldProperty.RK_MSG_SUCCESS;
		
		CompanyDto tknCompany = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
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
		
		CompanyDto tknCompany = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknAdminSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		/* implementation */
		
		Date curDt = new Date(System.currentTimeMillis());
		
		int agencySeq = NumberUtils.getNumber(props.get("id"));
		String firstGuide = StringUtils.getString(props.get("firstGuide"));
		
		Optional<Company> optCompany = this.companyRepository.findById(agencySeq);
		
		if (optCompany.isPresent()) {
			Company agency = optCompany.get();
			
			if (agency.hasOption(Option.AGENCY_first_guide)) {
				firstGuide = StringUtils.getString(firstGuide, agency.getOptionString(Option.AGENCY_first_guide));
			}
			
			agency.putOption(Option.AGENCY_first_guide, firstGuide);
			agency.setUpdDt(curDt);
			
			agency = this.companyRepository.save(agency);
		}  else {
			throw new BadRequestException("잘못된 접근입니다.");
		}
		
		/* implementation */
		
		return rtnMsg;
	}
	
	@Override
	@Transactional
	public String update(MemberDto user, IssueDto issueDto) {
		String rtnMsg = ShieldProperty.RK_MSG_SUCCESS;
		
		int tknCompanySeq = user.getCompanySeq();
		List<Integer> tknAdminSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		/* implementation */
		
		Date curDt = new Date(System.currentTimeMillis());
		
		String issueName = issueDto.getIssueName();
		String issueCeoName = issueDto.getIssueCeoName();
		String issueSsn = issueDto.getIssueSsn();
		String issueAddr = issueDto.getIssueAddr();
		String issueManagerName = issueDto.getIssueManagerName();
		String issueManagerPhone = issueDto.getIssueManagerPhone();
		String issueManagerEmail = issueDto.getIssueManagerEmail();
		String issueBizType = issueDto.getIssueBizType();
		String issueBizName = issueDto.getIssueBizName();
		String issueBizPhoto = issueDto.getIssueBizPhoto();
		String issueBankPhoto = issueDto.getIssueBankPhoto();

		Optional<Company> optCompany = this.companyRepository.findById(tknCompanySeq);
		
		if (optCompany.isPresent()) {
			Company agency = optCompany.get();
			
			if (agency.hasOption(Option.AGENCY_issue)) {
				Map<String, Object> issueOptionMap = (Map<String, Object>) agency.getOption(Option.AGENCY_issue);

				issueName = StringUtils.getString(issueName, StringUtils.getString(issueOptionMap.get(Option.AGENCY_issue_name)));
				issueCeoName = StringUtils.getString(issueCeoName, StringUtils.getString(issueOptionMap.get(Option.AGENCY_issue_ceo_name)));
				issueSsn = StringUtils.getString(issueSsn, StringUtils.getString(issueOptionMap.get(Option.AGENCY_issue_ssn)));
				issueAddr = StringUtils.getString(issueAddr, StringUtils.getString(issueOptionMap.get(Option.AGENCY_issue_addr)));
				issueManagerName = StringUtils.getString(issueManagerName, StringUtils.getString(issueOptionMap.get(Option.AGENCY_issue_manager_name)));
				issueManagerPhone = StringUtils.getString(issueManagerPhone, StringUtils.getString(issueOptionMap.get(Option.AGENCY_issue_manager_phone)));
				issueManagerEmail = StringUtils.getString(issueManagerEmail, StringUtils.getString(issueOptionMap.get(Option.AGENCY_issue_manager_email)));
				issueBizType = StringUtils.getString(issueBizType, StringUtils.getString(issueOptionMap.get(Option.AGENCY_issue_biz_type)));
				issueBizName = StringUtils.getString(issueBizName, StringUtils.getString(issueOptionMap.get(Option.AGENCY_issue_biz_name)));
				issueBizPhoto = StringUtils.getString(issueBizPhoto, StringUtils.getString(issueOptionMap.get(Option.AGENCY_issue_biz_photo)));
				issueBankPhoto = StringUtils.getString(issueBankPhoto, StringUtils.getString(issueOptionMap.get(Option.AGENCY_issue_bank_photo)));
			}
			
			Map<String, Object> agencyIssue = new HashMap<>();
			
			agencyIssue.put(Option.AGENCY_issue_name, issueName);
			agencyIssue.put(Option.AGENCY_issue_ceo_name, issueCeoName);
			agencyIssue.put(Option.AGENCY_issue_ssn, issueSsn);
			agencyIssue.put(Option.AGENCY_issue_addr, issueAddr);
			agencyIssue.put(Option.AGENCY_issue_manager_name, issueManagerName);
			agencyIssue.put(Option.AGENCY_issue_manager_phone, issueManagerPhone);
			agencyIssue.put(Option.AGENCY_issue_manager_email, issueManagerEmail);
			agencyIssue.put(Option.AGENCY_issue_biz_type, issueBizType);
			agencyIssue.put(Option.AGENCY_issue_biz_name, issueBizName);
			agencyIssue.put(Option.AGENCY_issue_biz_photo, issueBizPhoto);
			agencyIssue.put(Option.AGENCY_issue_bank_photo, issueBankPhoto);
			
			agency.putOption(Option.AGENCY_issue, agencyIssue);
			agency.setUpdDt(curDt);
			
			agency = this.companyRepository.save(agency);
		}  else {
			throw new BadRequestException("잘못된 접근입니다.");
		}
		
		/* implementation */
		
		return rtnMsg;
	}
	
	@Override
	@Transactional
	public String delete(MemberDto user, Map<String, Object> props) {
		String rtnMsg = ShieldProperty.RK_MSG_SUCCESS;
		
		CompanyDto tknCompany = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknAdminSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		/* implementation */
		
		/*
		 * team
		 * 
		 */
		List<String> tables = Arrays.asList("".split(","));
		for (String table : tables) {
			
		}
		
		/* implementation */
		
		return rtnMsg;
	}
	
}
