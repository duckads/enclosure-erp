package kr.co.shield.service.impl;

import jakarta.transaction.Transactional;

import kr.co.shield.domain.Member;
import kr.co.shield.domain.Role;
import kr.co.shield.dto.JoinDto;
import kr.co.shield.ext.Option;
import kr.co.shield.repository.MemberRepository;
import kr.co.shield.repository.RoleRepository;
import kr.co.shield.service.inf.JoinService;
import kr.co.shield.utility.FormatUtils;
import kr.co.shield.utility.NumberUtils;
import kr.co.shield.utility.StringUtils;
import kr.co.shield.common.ShieldProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class JoinServiceImpl implements JoinService {
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	private final RoleRepository roleRepository;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public String join(JoinDto joinDto) {
		String rtnMsg = ShieldProperty.RK_MSG_SUCCESS;
		
		Date curDt = new Date(System.currentTimeMillis());
		
		String username = joinDto.getUsername();
		String password = joinDto.getPassword();

		String memberNm = joinDto.getMemberNm();
		String memberPhone = joinDto.getMemberPhone();

		Member member = new Member();
		member.setMemberNm(memberNm);
		member.setMemberId(username);
		member.setMemberPw(this.passwordEncoder.encode(password));
		member.putOption(Option.ADMIN_phone, memberPhone);
		member.setActSt("201001");
		member.setRegDt(curDt);
		member.setUpdDt(curDt);

		Role role = roleRepository.findById(3).orElse(null);;

		member.getRoles().add(role);
		memberRepository.save(member);
		
		log.info("Request join# {}", joinDto);
		
		return rtnMsg;
	}
	
}
