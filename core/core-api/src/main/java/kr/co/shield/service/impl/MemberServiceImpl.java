package kr.co.shield.service.impl;

import jakarta.transaction.Transactional;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.domain.Member;
import kr.co.shield.dto.MemberDto;
import kr.co.shield.repository.MemberRepository;
import kr.co.shield.service.inf.MemberService;
import kr.co.shield.utility.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    MemberRepository memberRepository;

    @Override
    @Transactional
    public MemberDto findMember(String userId, String userRole) {
        MemberDto user = null;

        if (StringUtils.hasString(userId)) {
            Optional<Member> optMember = this.memberRepository.findByMemberId(userId);

            if (optMember.isPresent()) {
                user = optMember.get().getDto();

                if (user.getActSt().equals("201001")) {
                    List<String> roles = user.getRoles().stream()
                            .map(e -> "ROLE_" + e.toUpperCase())
                            .collect(Collectors.toList());
                    user.setRoles(roles);
                } else {
                    user = null;
                }
            }
        }

        return user;
    }
}
