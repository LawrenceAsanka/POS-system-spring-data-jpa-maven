package lk.ijse.dep.repository.custom.impl;

import lk.ijse.dep.repository.CrudDAOImpl;
import lk.ijse.dep.repository.custom.OrderDetailDAO;
import lk.ijse.dep.entity.OrderDetail;
import lk.ijse.dep.entity.OrderDetailPK;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDetailDAOImpl extends CrudDAOImpl<OrderDetail, OrderDetailPK> implements OrderDetailDAO {


}
