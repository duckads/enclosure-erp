package kr.co.shield.repository;


import kr.co.shield.domain.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MemberRoleRepository extends JpaRepository<MemberRole, Integer>, JpaSpecificationExecutor<MemberRole> {

}
