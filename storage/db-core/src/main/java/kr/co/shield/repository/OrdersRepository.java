package kr.co.shield.repository;

import kr.co.shield.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrdersRepository extends JpaRepository<Orders, String>, JpaSpecificationExecutor<Orders> {

}
