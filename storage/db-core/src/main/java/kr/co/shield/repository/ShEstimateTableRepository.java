package kr.co.shield.repository;

import kr.co.shield.domain.LegacyEstimateTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

public interface ShEstimateTableRepository extends JpaRepository<LegacyEstimateTable, Integer>, JpaSpecificationExecutor<LegacyEstimateTable> {
    Optional<List<LegacyEstimateTable>> findByEstimateCode(@Param("estimateCode") String estimateCode);
}
