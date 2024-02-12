package kr.co.shield.repository;

import kr.co.shield.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NoticeRepository extends JpaRepository<Notice, Integer>, JpaSpecificationExecutor<Notice> {

}
