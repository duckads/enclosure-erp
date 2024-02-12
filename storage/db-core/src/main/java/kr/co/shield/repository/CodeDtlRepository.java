package kr.co.shield.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import kr.co.shield.domain.CodeDtl;

public interface CodeDtlRepository extends JpaRepository<CodeDtl, String>, JpaSpecificationExecutor<CodeDtl> {

}
