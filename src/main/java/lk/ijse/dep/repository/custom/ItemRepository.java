package lk.ijse.dep.repository.custom;

import lk.ijse.dep.repository.CrudDAO;
import lk.ijse.dep.entity.Item;

public interface ItemRepository extends CrudDAO<Item, String> {

    String getLastItemCode() throws Exception;

}
