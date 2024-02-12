package kr.co.shield.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
import kr.co.shield.dto.QnaDto;
import kr.co.shield.dto.ResponseDto;
import kr.co.shield.service.inf.QnaService;
import kr.co.shield.utility.StringUtils;
import lombok.RequiredArgsConstructor;

@RequestMapping(value = "/qnas", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@RestController
@Tag(name = "Q&A", description = "Q&A")
public class QnaController {

    private final QnaService qnaService;

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
    @GetMapping
    @Operation(summary = "List", security = @SecurityRequirement(name = ShieldProperty.SPRINGDOC_SECURITY_NAME))
    public ResponseEntity<List<QnaDto>> list(HttpServletRequest request) {
        List<QnaDto> rtnList = null;

        MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);

        String qnaTp = StringUtils.getString(request.getParameter("qnaTp"));
        String qnaSt = StringUtils.getString(request.getParameter("qnaSt"));

        Map<String, Object> props = Map.of();
        props.put("qnaTps", qnaTp);
        props.put("qnaSts", qnaSt);

        rtnList = this.qnaService.findAll(user, props);

        return ResponseEntity.ok(rtnList);
    }

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
    @Operation(summary = "질문")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> create(HttpServletRequest request) {
        String rtnMsg = "직원이 등록되었습니다.";

        MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);

        Map<String, Object> props = new HashMap<>();
        props.put("qnaTps", "qnaTp");
        props.put("qnaSts", "qnaSt");

        this.qnaService.create(user, props);

        ResponseDto responseDto = ResponseDto.builder()
                .status(HttpStatus.OK)
                .message(rtnMsg)
                .build();

        return ResponseEntity.ok(responseDto);
    }

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
    @Operation(summary = "답변")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> update(HttpServletRequest request) {
        String rtnMsg = "직원이 등록되었습니다.";

        MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);

        Map<String, Object> props = new HashMap<>();
        props.put("qnaTps", "qnaTp");
        props.put("qnaSts", "qnaSt");

        this.qnaService.update(user, props);

        ResponseDto responseDto = ResponseDto.builder()
                .status(HttpStatus.OK)
                .message(rtnMsg)
                .build();

        return ResponseEntity.ok(responseDto);
    }

}
