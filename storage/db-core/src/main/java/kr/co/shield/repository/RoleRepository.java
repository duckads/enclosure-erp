package kr.co.shield.repository;


import kr.co.shield.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {
	
	Optional<Role> findByRoleNm(@Param("roleNm") String roleNm);
	
}
