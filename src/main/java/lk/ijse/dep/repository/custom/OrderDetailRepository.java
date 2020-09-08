package lk.ijse.dep.repository.custom;

import lk.ijse.dep.repository.CrudDAO;
import lk.ijse.dep.entity.OrderDetail;
import lk.ijse.dep.entity.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {

}
