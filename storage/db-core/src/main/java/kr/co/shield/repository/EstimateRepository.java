package kr.co.shield.repository;

import kr.co.shield.domain.Estimate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EstimateRepository extends JpaRepository<Estimate, Integer>, JpaSpecificationExecutor<Estimate> {
}
