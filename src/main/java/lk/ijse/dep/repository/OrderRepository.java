package lk.ijse.dep.repository;

import lk.ijse.dep.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {

    Order getFirstLastOrderIdByOrderByIdDesc() throws Exception;

}
