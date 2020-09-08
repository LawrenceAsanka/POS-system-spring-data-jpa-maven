package lk.ijse.dep.repository.custom;

import lk.ijse.dep.repository.CrudDAO;
import lk.ijse.dep.entity.Order;

public interface OrderDAO extends CrudDAO<Order, String> {

    String getLastOrderId() throws Exception;

}
