package lk.ijse.dep.repository.custom;

import lk.ijse.dep.repository.SuperDAO;
import lk.ijse.dep.entity.CustomEntity;

import java.util.List;

public interface QueryDAO extends SuperDAO {

    List<CustomEntity> getOrderDetail() throws Exception;
}
