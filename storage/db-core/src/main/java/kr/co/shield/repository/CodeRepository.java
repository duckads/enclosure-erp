package kr.co.shield.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import kr.co.shield.domain.Code;

public interface CodeRepository extends JpaRepository<Code, String>, JpaSpecificationExecutor<Code> {

}
