package lk.ijse.dep.repository;

import lk.ijse.dep.entity.OrderDetail;
import lk.ijse.dep.entity.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {

}
