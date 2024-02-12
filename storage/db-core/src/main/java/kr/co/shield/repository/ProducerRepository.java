package kr.co.shield.repository;

import kr.co.shield.domain.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProducerRepository extends JpaRepository<Producer, Integer>, JpaSpecificationExecutor<Producer> {
}
