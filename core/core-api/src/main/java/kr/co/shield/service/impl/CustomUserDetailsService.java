package kr.co.shield.service.impl;

import jakarta.transaction.Transactional;
import kr.co.shield.domain.User;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.repository.MemberRepository;
import kr.co.shield.domain.Member;
import kr.co.shield.ext.Option;
import kr.co.shield.utility.NumberUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private final MemberRepository memberRepository;
	
	@Cacheable
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String adminId) throws UsernameNotFoundException {
		Member member = this.memberRepository.findByMemberId(adminId).orElseThrow(() -> new UsernameNotFoundException("회원 정보가 없습니다."));
		List<String> roles = member.getRoles().stream()
				.map(e -> "ROLE_" + e.getRoleNm().toUpperCase())
				.collect(Collectors.toList());

		User user = User.builder()
				.adminId(member.getMemberId())
				.adminPw(member.getMemberPw())
				.adminNm(member.getMemberNm())
				.actSt(member.getActSt())
				.roles(roles)
				.build();

		int loginCnt = NumberUtils.getNumber(member.getOption(Option.ADMIN_login_cnt));
		member.putOption(Option.ADMIN_login_cnt, ++loginCnt);
		member.putOption(Option.ADMIN_login_dt, ShieldProperty.DT_FORMATTER.format(Instant.now().truncatedTo(ChronoUnit.SECONDS)));
		
		return user;
	}
	
}
