package kr.co.shield.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.dto.MemberDto;
import kr.co.shield.dto.IssueDto;
import kr.co.shield.dto.ResponseDto;
import kr.co.shield.service.inf.CompanyService;
import kr.co.shield.utility.FileUtils;
import lombok.RequiredArgsConstructor;

@RequestMapping(value = "/issue", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@RestController
@Tag(name = "Issue", description = "세금계산서")
public class IssueController {

    private final CompanyService companyService;

    @Value("${refiner.path.upload:}")
    private String pathUpload;

    private String pathUploadIssuePhoto;

    @PostConstruct
    private void init() {
        this.pathUploadIssuePhoto = this.pathUpload + ShieldProperty.RK_REFINER_PATH_UPLOAD_issue_photo;
    }

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
    @Operation(summary = "세금계산서 정보 수정")
    @PostMapping(value = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<ResponseDto> update(HttpServletRequest request, @RequestPart IssueDto issueDto, @RequestPart(required = false) MultipartFile uploadFile1, @RequestPart(required = false) MultipartFile uploadFile2) {
        String rtnMsg = "세금계산서 정보가 수정되었습니다.";

        MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);

        // 파일 업로드
        String result1 = FileUtil.uploadMultipartFile(this.pathUploadIssuePhoto, uploadFile1);
        if (result1.startsWith(ShieldProperty.RK_RESULT_Y)) {
            String issueBizPhoto = ShieldProperty.RK_REFINER_PATH_UPLOAD_issue_photo;
            issueBizPhoto += result1.substring(ShieldProperty.RK_MSG_SUCCESS.length());
            issueDto.setIssueBizPhoto(issueBizPhoto);
        }

        String result2 = FileUtil.uploadMultipartFile(this.pathUploadIssuePhoto, uploadFile2);
        if (result2.startsWith(ShieldProperty.RK_RESULT_Y)) {
            String issueBankPhoto = ShieldProperty.RK_REFINER_PATH_UPLOAD_issue_photo;
            issueBankPhoto += result2.substring(ShieldProperty.RK_MSG_SUCCESS.length());
            issueDto.setIssueBankPhoto(issueBankPhoto);
        }

        this.companyService.update(user, issueDto);

        ResponseDto responseDto = ResponseDto.builder()
                .status(HttpStatus.OK)
                .message(rtnMsg)
                .build();

        return ResponseEntity.ok(responseDto);
    }
}
