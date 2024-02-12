package kr.co.shield.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import kr.co.shield.dto.OrdersDto;
import kr.co.shield.dto.OrderDto;
import kr.co.shield.dto.ResponseDto;
import kr.co.shield.service.inf.OrdersService;
import lombok.RequiredArgsConstructor;

@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@RestController
@Tag(name = "Orders", description = "결제")
public class OrdersController {

    private final OrdersService ordersService;

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
    @GetMapping
    @Operation(summary = "List", security = @SecurityRequirement(name = ShieldProperty.SPRINGDOC_SECURITY_NAME))
    public ResponseEntity<List<OrdersDto>> list(HttpServletRequest request) {
        List<OrdersDto> rtnList = null;

        MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);

        Map<String, Object> props = new HashMap<>();

        props.put("agencySeq", request.getParameter("agency_seq"));
        props.put("adminSeq", request.getParameter("admin_seq"));
        props.put("orderSt", request.getParameter("order_st"));
        props.put("payTp", request.getParameter("pay_tp"));
        props.put("psDate", request.getParameter("ps_date"));
        props.put("peDate", request.getParameter("pe_date"));

        rtnList = this.ordersService.findAll(user, props);

        return ResponseEntity.ok(rtnList);
    }

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
    @GetMapping("/{id}")
    @Operation(summary = "Get", security = @SecurityRequirement(name = ShieldProperty.SPRINGDOC_SECURITY_NAME))
    public ResponseEntity<OrdersDto> get(HttpServletRequest request, @PathVariable(required = true, name = "id") final String id) {
        OrdersDto rtnObj = null;

        MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);

        Map<String, Object> props = Map.of("id", id);

        rtnObj = this.ordersService.findOne(user, props);

        return ResponseEntity.ok(rtnObj);
    }

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
    @Operation(summary = "Create", security = @SecurityRequirement(name = ShieldProperty.SPRINGDOC_SECURITY_NAME))
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> create(HttpServletRequest request) {
        String rtnMsg = null;

        MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);

        Map<String, Object> props = null;

        rtnMsg = this.ordersService.create(user, props);

        ResponseDto responseDto = ResponseDto.builder()
                .message(rtnMsg)
                .build();

        return ResponseEntity.ok(responseDto);
    }

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
    @Operation(summary = "Update", security = @SecurityRequirement(name = ShieldProperty.SPRINGDOC_SECURITY_NAME))
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> update(HttpServletRequest request, @PathVariable(required = true, name = "id") final String id) {
        String rtnMsg = null;

        MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);

        Map<String, Object> props = Map.of("id", id);

        rtnMsg = this.ordersService.update(user, props);

        ResponseDto responseDto = ResponseDto.builder()
                .message(rtnMsg)
                .build();

        return ResponseEntity.ok(responseDto);
    }

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete", security = @SecurityRequirement(name = ShieldProperty.SPRINGDOC_SECURITY_NAME))
    public ResponseEntity<ResponseDto> delete(HttpServletRequest request, @PathVariable(required = true, name = "id") final String id) {
        String rtnMsg = null;

        MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);

        Map<String, Object> props = Map.of("id", id);

        rtnMsg = this.ordersService.delete(user, props);

        ResponseDto responseDto = ResponseDto.builder()
                .message(rtnMsg)
                .build();

        return ResponseEntity.ok(responseDto);
    }

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
    @PostMapping(value = "/preview", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Preview", security = @SecurityRequirement(name = ShieldProperty.SPRINGDOC_SECURITY_NAME))
    public ResponseEntity<?> preview(HttpServletRequest request, @RequestBody OrderDto orderDto) {
        Map<String, Object> rtnMap = null;

        MemberDto user = (MemberDto)request.getAttribute(ShieldProperty.TKN_USER);

        rtnMap = this.ordersService.preview(user, orderDto);

        return ResponseEntity.ok(rtnMap);
    }

}
