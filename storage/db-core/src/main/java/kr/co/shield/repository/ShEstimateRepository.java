package kr.co.shield.repository;

import kr.co.shield.domain.Estimate;
import kr.co.shield.domain.LegacyEstimate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShEstimateRepository extends JpaRepository<LegacyEstimate, Integer>, JpaSpecificationExecutor<LegacyEstimate> {
}
