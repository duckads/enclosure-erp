package kr.co.shield.repository;

import kr.co.shield.domain.EstimateDtl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EstimateDtlRepository extends JpaRepository<EstimateDtl, Integer>, JpaSpecificationExecutor<EstimateDtl> {
}
