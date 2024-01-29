package kr.co.shield.service.inf;

import kr.co.shield.dto.ExternalMemberDto;
import kr.co.shield.dto.MemberDto;

import java.util.List;

public interface MemberService {
    public List<MemberDto> findAll();
    public MemberDto findMember(String userId, String userRole);

    public List<ExternalMemberDto> findExternalAll();

    public ExternalMemberDto findExternalMember();
}
