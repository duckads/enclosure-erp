package kr.co.shield.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.dto.EstimateDto;
import kr.co.shield.dto.EstimateDto;
import kr.co.shield.service.inf.EstimateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "/estimates", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@RestController
public class EstimateController {
    
    private final EstimateService estimateService;
    
    @GetMapping
    public ResponseEntity<List<EstimateDto>> list(HttpServletRequest request) {
        List<EstimateDto> rtnList = null;

         rtnList = this.estimateService.findAll();

        return ResponseEntity.ok(rtnList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstimateDto> get(HttpServletRequest request, @PathVariable(required = true, name = "id") final String id) {
        EstimateDto rtnObj = null;

        rtnObj = this.estimateService.findEstimate(Integer.parseInt(id));

        return ResponseEntity.ok(rtnObj);
    }
}
