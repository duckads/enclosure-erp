package kr.co.shield.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import kr.co.shield.common.CodeManager;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.domain.Qna;
import kr.co.shield.dto.MemberDto;
import kr.co.shield.dto.CompanyDto;
import kr.co.shield.dto.QnaDto;
import kr.co.shield.ext.Option;
import kr.co.shield.repository.QnaRepository;
import kr.co.shield.service.inf.QnaService;
import kr.co.shield.util.JpaUtil;
import kr.co.shield.utility.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
//@SuppressWarnings({ "unchecked", "unused" })
public class QnaServiceImpl implements QnaService {
	
	@PersistenceContext
	private final EntityManager entityManager;
	
	private final QnaRepository qnaRepository;
	
	private final MessageSource messageSource;
	
	/**
	 * RestApi
	 */
	@Override
	@Transactional
	public List<QnaDto> findAll(MemberDto user, Map<String, Object> props) {
		List<QnaDto> rtnList = null;
		
		CompanyDto tknAgency = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknMemberSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		/* implementation */
		
		String qnaTps = StringUtils.getString(props.get("qnaTps"));
		String qnaSts = StringUtils.getString(props.get("qnaSts"));
		
		Specification<Qna> where = JpaUtil.equal(Qna.class, "agencySeq", tknAgency.getSeq());
		if (!qnaTps.isBlank()) {
			where = where.and(JpaUtil.in(Qna.class, "qnaTp", Arrays.asList(qnaTps.split(","))));
		}
		if (!qnaSts.isBlank()) {
			where = where.and(JpaUtil.in(Qna.class, "qnaSt", Arrays.asList(qnaSts.split(","))));
		}
		
		List<Qna> qnas = this.qnaRepository.findAll(where);
		if (qnas.isEmpty()) {
			rtnList = Collections.emptyList();
		} else {
			rtnList = qnas.stream()
					.map(e -> e.getDto())
					.collect(Collectors.toList());
		}
		
		/* implementation */
		
		return rtnList;
	}
	
	@Override
	@Transactional
	public QnaDto findOne(MemberDto user, Map<String, Object> props) {
		QnaDto rtnObj = null;
		
		CompanyDto tknAgency = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknMemberSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		/* implementation */
		
		Date curDt = new Date(System.currentTimeMillis());
		
		String qnaTp = StringUtils.getString(props.get("qnaTp"));
		String subject = StringUtils.getString(props.get("subject"));
		String question = StringUtils.getString(props.get("question"));
		String qnaSt = CodeManager.code("QNA_ST_REGISTER");
		String appNo = StringUtils.getString(props.get("appNo"));
		String clientSeq = StringUtils.getString(props.get("clientSeq"));
		String clientNm = StringUtils.getString(props.get("clientNm"));
		
		Qna qna = new Qna();
		qna.setQnaTp(qnaTp);
		qna.setSubject(subject);
		qna.setQuestion(question);
		qna.setAnswering("");
		qna.setQnaSt(qnaSt);
		qna.setRegDt(curDt);
		qna.setUpdDt(curDt);
		qna.setCompanySeq(user.getCompanySeq());
		qna.setMemberSeq(user.getSeq());
		qna.setParentSeq(0);
		
		qna.putOption(Option.QNA_q_admin_id, user.getMemberId());
		qna.putOption(Option.QNA_q_admin_nm, user.getMemberNm());
		qna.putOption(Option.QNA_q_client_seq, clientSeq);
		qna.putOption(Option.QNA_q_client_nm, clientNm);
		
		this.qnaRepository.save(qna);
		
		/* implementation */
		
		return rtnObj;
	}
	
	@Override
	@Transactional
	public String create(MemberDto user, Map<String, Object> props) {
		String rtnMsg = ShieldProperty.RK_MSG_SUCCESS;
		
		CompanyDto tknAgency = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknMemberSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
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
		List<Integer> tknMemberSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
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
		List<Integer> tknMemberSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		List<Integer> tknClientSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_CLIENT);
		List<Integer> tknTeamSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_TEAM);
		
		/* implementation */
		
		
		
		/* implementation */
		
		return rtnMsg;
	}
	
}
