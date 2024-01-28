package kr.co.shield;

import kr.co.shield.domain.Member;
import kr.co.shield.domain.MemberRole;
import kr.co.shield.domain.Role;
import kr.co.shield.dto.MemberDto;
import kr.co.shield.dto.RoleDto;
import kr.co.shield.repository.MemberRepository;
import kr.co.shield.repository.MemberRoleRepository;
import kr.co.shield.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
public class CoreTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberRoleRepository memberRoleRepository;

    @Test
    void setData() {

        Member member = new Member();
        member.setMemberNm("안성재");
        member.setMemberPw("쓰마트0)");
        member.setMemberId("asj");
        member.setMemberOption("");
        member.setRegDt(new Date());
        member.setUpdDt(new Date());
        member.setActSt("201001");
        memberRepository.save(member);

        MemberRole memberRole = new MemberRole();
        memberRole.setMemberSeq(member.getSeq());
        memberRole.setRoleSeq(3);


        memberRoleRepository.save(memberRole);
    }

    @Test
    void setData2() {

        Optional<Member> member = memberRepository.findByMemberId("asj");

        MemberRole memberRole = new MemberRole();
        memberRole.setMemberSeq(1);
        memberRole.setRoleSeq(3);

        memberRoleRepository.save(memberRole);
    }
}
