package lk.ijse.dep.repository;

import lk.ijse.dep.entity.CustomEntity;
import lk.ijse.dep.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {

    Order getFirstLastOrderIdByOrderByIdDesc() throws Exception;

    List<CustomEntity> getAllOrderDetails() throws Exception;

    List<CustomEntity> getAllOrderDetails2() throws Exception;
}
