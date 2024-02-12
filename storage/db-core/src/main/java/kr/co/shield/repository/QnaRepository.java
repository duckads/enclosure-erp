package kr.co.shield.repository;

import kr.co.shield.domain.Qna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface QnaRepository extends JpaRepository<Qna, Integer>, JpaSpecificationExecutor<Qna> {

}
