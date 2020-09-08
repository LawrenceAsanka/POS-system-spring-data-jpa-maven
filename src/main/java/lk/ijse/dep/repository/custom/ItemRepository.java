package lk.ijse.dep.repository.custom;

import lk.ijse.dep.repository.CrudDAO;
import lk.ijse.dep.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {

    String getLastItemCode() throws Exception;

}
