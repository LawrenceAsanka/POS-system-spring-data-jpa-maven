package lk.ijse.dep.repository.custom;

import lk.ijse.dep.repository.CrudDAO;
import lk.ijse.dep.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {

    String getLastOrderId() throws Exception;

}
