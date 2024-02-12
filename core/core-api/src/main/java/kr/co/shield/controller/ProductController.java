package kr.co.bizspring.gp.resource.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import kr.co.shield.dto.ProductDto;
import kr.co.shield.service.inf.ProductService;
import kr.co.shield.utility.StringUtils;
import lombok.RequiredArgsConstructor;

@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@RestController
@Tag(name = "Product", description = "상품")
public class ProductController {

    private final ProductService productService;

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
    @GetMapping
    @Operation(summary = "List", security = @SecurityRequirement(name = ShieldProperty.SPRINGDOC_SECURITY_NAME))
    public ResponseEntity<List<ProductDto>> list(HttpServletRequest request) {
        List<ProductDto> rtnList = null;

        MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);

        String productTp = StringUtils.getString(request.getParameter("product_tp"));

        Map<String, Object> props = Map.of("productTp", productTp);

        rtnList = this.productService.findAll(user, props);

        return ResponseEntity.ok(rtnList);
    }

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
    @GetMapping("/{id}")
    @Operation(summary = "Get", security = @SecurityRequirement(name = ShieldProperty.SPRINGDOC_SECURITY_NAME))
    public ResponseEntity<ProductDto> get(HttpServletRequest request, @PathVariable(required = true, name = "id") final Integer id) {
        ProductDto rtnObj = null;

        MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);

        Map<String, Object> props = Map.of("id", id);

        rtnObj = this.productService.findOne(user, props);

        return ResponseEntity.ok(rtnObj);
    }

//	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
//	@Operation(summary = "Create", security = @SecurityRequirement(name = ShieldProperty.SPRINGDOC_SECURITY_NAME))
//	@PostMapping
//	public ResponseEntity<ResponseDto> create(HttpServletRequest request) {
//		MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);
//
//		Map<String, Object> props = null;
//
//		String rtnMsg = this.productService.create(user, props);
//
//		ResponseDto responseDto = ResponseDto.builder()
//				.message(rtnMsg)
//				.build();
//
//		return ResponseEntity.ok(responseDto);
//	}
//
//	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
//	@Operation(summary = "Update", security = @SecurityRequirement(name = ShieldProperty.SPRINGDOC_SECURITY_NAME))
//	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<ResponseDto> update(HttpServletRequest request, @PathVariable(required = true, name = "id") final Integer id) {
//		MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);
//
//		Map<String, Object> props = Map.of("id", id);
//
//		String rtnMsg = this.productService.update(user, props);
//
//		ResponseDto responseDto = ResponseDto.builder()
//				.message(rtnMsg)
//				.build();
//
//		return ResponseEntity.ok(responseDto);
//	}
//
//	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
//	@DeleteMapping("/{id}")
//	@Operation(summary = "Delete", security = @SecurityRequirement(name = ShieldProperty.SPRINGDOC_SECURITY_NAME))
//	public ResponseEntity<ResponseDto> delete(HttpServletRequest request, @PathVariable(required = true, name = "id") final Integer id) {
//		MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);
//
//		Map<String, Object> props = Map.of("id", id);
//
//		String rtnMsg = this.productService.delete(user, props);
//
//		ResponseDto responseDto = ResponseDto.builder()
//				.message(rtnMsg)
//				.build();
//
//		return ResponseEntity.ok(responseDto);
//	}
//
}
