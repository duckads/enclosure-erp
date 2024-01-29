package kr.co.shield.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.dto.ExternalMemberDto;
import kr.co.shield.dto.MemberDto;
import kr.co.shield.service.inf.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "/member", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<MemberDto>> list(HttpServletRequest request) {
        List<MemberDto> rtnList = null;

        rtnList = this.memberService.findAll();

        return ResponseEntity.ok(rtnList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> get(HttpServletRequest request, @PathVariable(required = true, name = "id") final String id) {
        MemberDto rtnObj = null;

        MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);

        Map<String, Object> props = Map.of("id", id);

        rtnObj = this.memberService.findMember(user.getMemberId(), "201001");

        return ResponseEntity.ok(rtnObj);
    }

    @GetMapping("/external")
    public ResponseEntity<ExternalMemberDto> externalList(HttpServletRequest request) {
        ExternalMemberDto rtnObj = null;

        rtnObj = this.memberService.findExternalMember();

        return ResponseEntity.ok(rtnObj);
    }
}
