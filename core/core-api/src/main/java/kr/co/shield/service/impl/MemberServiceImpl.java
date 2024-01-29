package kr.co.shield.service.impl;

import jakarta.transaction.Transactional;
import kr.co.shield.domain.ExternalMember;
import kr.co.shield.domain.Member;
import kr.co.shield.dto.ExternalMemberDto;
import kr.co.shield.dto.MemberDto;
import kr.co.shield.repository.ExternalMemberRepository;
import kr.co.shield.repository.MemberRepository;
import kr.co.shield.service.inf.MemberService;
import kr.co.shield.utility.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final ExternalMemberRepository externalMemberRepository;

    @Override
    public List<MemberDto> findAll() {
        List<MemberDto> rtnList = null;

        List<Member> members = this.memberRepository.findAll();
        if (members.isEmpty()) {
            rtnList = Collections.emptyList();
        } else {
            rtnList = members.stream()
                    .map(e -> e.getDto())
                    .collect(Collectors.toList());
        }
        return rtnList;
    }

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

    @Override
    public List<ExternalMemberDto> findExternalAll() {
        List<ExternalMemberDto> rtnList = null;
        List<ExternalMember> members = this.externalMemberRepository.findAll();
        if (members.isEmpty()) {
            rtnList = Collections.emptyList();
        } else {
            rtnList = members.stream()
                    .map(e -> e.getDto())
                    .collect(Collectors.toList());
        }

        return rtnList;
    }

    @Override
    public ExternalMemberDto findExternalMember() {
        ExternalMemberDto rtnObj = null;
        return rtnObj;
    }
}
