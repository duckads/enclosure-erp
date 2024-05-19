package kr.co.shield.controller;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.dto.MemberDto;
import kr.co.shield.dto.NoticeDto;
import kr.co.shield.service.inf.NoticeService;
import lombok.RequiredArgsConstructor;

@RequestMapping(value = "/notices", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@RestController
@Tag(name = "Notice", description = "공지")
public class NoticeController {

    private final NoticeService noticeService;

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
    @GetMapping
    @Operation(summary = "List", security = @SecurityRequirement(name = ShieldProperty.SPRINGDOC_SECURITY_NAME))
    public ResponseEntity<List<NoticeDto>> list(HttpServletRequest request) {
        List<NoticeDto> rtnList = null;

        MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);

        rtnList = this.noticeService.findAll(user, null);

        return ResponseEntity.ok(rtnList);
    }

}