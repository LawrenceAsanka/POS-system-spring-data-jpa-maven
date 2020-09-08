package lk.ijse.dep.repository.custom.impl;

import lk.ijse.dep.repository.CrudDAOImpl;
import lk.ijse.dep.repository.custom.OrderRepository;
import lk.ijse.dep.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl extends CrudDAOImpl<Order, String> implements OrderRepository {

    public String getLastOrderId() throws Exception {
        List list = entityManager.createQuery("SELECT o.id FROM lk.ijse.dep.entity.Order o ORDER BY id DESC").setMaxResults(1).getResultList();
        return list.size() > 0 ? (String) list.get(0) : null;
    }

}
