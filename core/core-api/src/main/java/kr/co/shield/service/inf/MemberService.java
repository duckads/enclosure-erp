package kr.co.shield.service.inf;

import kr.co.shield.dto.MemberDto;

public interface MemberService {
    public MemberDto findMember(String userId, String userRole);
}
