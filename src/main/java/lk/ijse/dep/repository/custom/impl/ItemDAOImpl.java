package lk.ijse.dep.repository.custom.impl;

import lk.ijse.dep.repository.CrudDAOImpl;
import lk.ijse.dep.repository.custom.ItemDAO;
import lk.ijse.dep.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDAOImpl extends CrudDAOImpl<Item, String> implements ItemDAO {


    public String getLastItemCode() throws Exception {
        List list = entityManager.createQuery("SELECT i.code FROM lk.ijse.dep.entity.Item i ORDER BY i.code DESC").setMaxResults(1).getResultList();
        return list.size() > 0 ? (String) list.get(0) : null;

    }

}
