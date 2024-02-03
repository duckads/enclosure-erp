package kr.co.shield.repository;

import kr.co.shield.domain.LegacyEstimateDtlTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

public interface ShEstimateDtlTableRepository extends JpaRepository<LegacyEstimateDtlTable, Integer>, JpaSpecificationExecutor<LegacyEstimateDtlTable> {

   List<LegacyEstimateDtlTable> findByEstimateCode(@Param("estimateCode") String estimateCode);
}
