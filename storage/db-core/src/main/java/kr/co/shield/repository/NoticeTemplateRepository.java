package kr.co.shield.repository;

import kr.co.shield.domain.NoticeTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticeTemplateRepository extends JpaRepository<NoticeTemplate, Integer>, JpaSpecificationExecutor<NoticeTemplate> {
	
	public List<NoticeTemplate> findByTemplateTagLike(@Param("templateTag") String templateTag);
	
}
