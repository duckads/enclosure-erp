package kr.co.shield.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.repository.NoticeTemplateRepository;
import kr.co.shield.dto.MemberDto;
import kr.co.shield.dto.CompanyDto;
import kr.co.shield.dto.NoticeTemplateDto;
import kr.co.shield.service.inf.NoticeTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
//@SuppressWarnings({ "unchecked", "unused" })
public class NoticeTemplateServiceImpl implements NoticeTemplateService {
	
	@PersistenceContext
	private final EntityManager entityManager;
	
	private final NoticeTemplateRepository noticeTemplateRepository;
	
	private final MessageSource messageSource;
	
	/**
	 * RestApi
	 */
	@Override
	@Transactional
	public List<NoticeTemplateDto> findAll(MemberDto user, Map<String, Object> props) {
		List<NoticeTemplateDto> rtnList = null;
		
		CompanyDto tknAgency = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknAdminSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		/* implementation */
		
		
		
		/* implementation */
		
		return rtnList;
	}
	
	@Override
	@Transactional
	public NoticeTemplateDto findOne(MemberDto user, Map<String, Object> props) {
		NoticeTemplateDto rtnObj = null;
		
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
