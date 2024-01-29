package kr.co.shield.service.impl;

import jakarta.transaction.Transactional;
import kr.co.shield.domain.Estimate;
import kr.co.shield.dto.EstimateDto;
import kr.co.shield.repository.EstimateRepository;
import kr.co.shield.service.inf.EstimateService;
import kr.co.shield.utility.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EstimateServiceImpl implements EstimateService {

    private final EstimateRepository estimateRepository;

    @Override
    public List<EstimateDto> findAll() {
        List<EstimateDto> rtnList = null;

        List<Estimate> estimates = this.estimateRepository.findAll();
        if (estimates.isEmpty()) {
            rtnList = Collections.emptyList();
        } else {
            rtnList = estimates.stream()
                    .map(e -> e.getDto())
                    .collect(Collectors.toList());
        }
        return rtnList;
    }

    @Override
    @Transactional
    public EstimateDto findEstimate(int seq) {
        EstimateDto rtnObj = null;

        Optional<Estimate> estimate = this.estimateRepository.findById(seq);
        rtnObj = estimate.get().getDto();

        return rtnObj;
    }
}
