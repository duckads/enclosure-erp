package kr.co.shield.service.inf;



import kr.co.shield.dto.EstimateDto;

import java.util.List;

public interface EstimateService {
    public List<EstimateDto> findAll();
    public EstimateDto findEstimate(int seq);
}
