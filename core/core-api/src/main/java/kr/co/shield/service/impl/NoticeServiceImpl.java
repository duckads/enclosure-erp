package kr.co.shield.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import kr.co.shield.common.CodeManager;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.repository.NoticeRepository;
import kr.co.shield.repository.NoticeTemplateRepository;
import kr.co.shield.domain.Notice;
import kr.co.shield.domain.NoticeTemplate;
import kr.co.shield.dto.MemberDto;
import kr.co.shield.dto.CompanyDto;
import kr.co.shield.dto.NoticeDto;
import kr.co.shield.ext.Option;
import kr.co.shield.service.impl.ext.MessageServiceImpl;
import kr.co.shield.service.inf.NoticeService;
import kr.co.shield.util.JpaUtil;
import kr.co.shield.utility.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@SuppressWarnings({ "unchecked", "unused" })
public class NoticeServiceImpl implements NoticeService {
	
	@PersistenceContext
	private final EntityManager entityManager;
	
	private final NoticeRepository noticeRepository;
	private final NoticeTemplateRepository noticeTemplateRepository;
	
	private final MessageSource messageSource;
	
	private final MessageServiceImpl messageService;
	
	@Value("${refiner.path.inline:}")
	private String pathInline;
	
	/**
	 * RestApi
	 */
	@Override
	@Transactional
	public List<NoticeDto> findAll(MemberDto user, Map<String, Object> props) {
		List<NoticeDto> rtnList = null;
		
		CompanyDto tknAgency = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknMemberSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		
		/* implementation */
		
		List<String> codes = List.of(CodeManager.code("NOTICE_TP_SVC"),
				CodeManager.code("NOTICE_TP_OPS"),
				CodeManager.code("NOTICE_TP_EVENT"));
		
		Specification<Notice> where = JpaUtil.in(Notice.class, "noticeSt", codes);
		
		List<Notice> notices = this.noticeRepository.findAll(where);
		if (notices.isEmpty()) {
			rtnList = Collections.emptyList();
		} else {
			rtnList = notices.stream()
					.map(e -> e.getDto())
					.collect(Collectors.toList());
		}
		
		/* implementation */
		
		return rtnList;
	}
	
	@Override
	@Transactional
	public NoticeDto findOne(MemberDto user, Map<String, Object> props) {
		NoticeDto rtnObj = null;
		
		CompanyDto tknAgency = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknMemberSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		
		/* implementation */
		
		
		
		/* implementation */
		
		return rtnObj;
	}
	
	@Override
	@Transactional
	public String create(MemberDto user, Map<String, Object> props) {
		String rtnMsg = ShieldProperty.RK_MSG_SUCCESS;
		
		CompanyDto tknAgency = (CompanyDto)user.getOption(ShieldProperty.TKN_USER_AGENCY);
		List<Integer> tknMemberSeq = (List<Integer>)user.getOption(ShieldProperty.TKN_USER_ADMIN);
		
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
		
		/* implementation */
		
		
		
		/* implementation */
		
		return rtnMsg;
	}
	
	/* Additional */
	
	@Override
	public String send(String templateTag, String recipient, Map<String, Object> param) {
		String rtnMsg = ShieldProperty.RK_MSG_SUCCESS;
		
		List<NoticeTemplate> templates = this.noticeTemplateRepository.findByTemplateTagLike("%" + templateTag + "%");
		
		if (templates != null && !templates.isEmpty()) {
			for (NoticeTemplate template : templates) {
				String channelTp = template.getChannelTp();
				
				String subject = template.getSubject();
				String content = template.getContent();
				String templateImage = template.getOptionString(Option.NOTICE_TEMPLATE_inline_image);
				
				String contents = StringUtils.replace(content, param);
				
				if (channelTp.equals(CodeManager.code("CHANNEL_TP_EMAIL"))) {
					subject = StringUtils.replace(subject, param);
					
					List<String> inlineFiles = new ArrayList<>();
					for (String imageFile : templateImage.split(",")) {
						imageFile = imageFile.trim();
						if (imageFile.length() > 0) {
							inlineFiles.add(imageFile);
						}
					}
					
					Map<Integer, Object> inlineMap = null;
					if (inlineFiles.size() > 0) {
						inlineMap = Map.of(MessageServiceImpl.INLINE_PATH, this.pathInline, MessageServiceImpl.INLINE_FILE, inlineFiles);
					}
					
					rtnMsg = this.messageService.sendMail(subject, contents, inlineMap, null, recipient);
				}
			}
		}
		
		return rtnMsg;
	}
	
}
