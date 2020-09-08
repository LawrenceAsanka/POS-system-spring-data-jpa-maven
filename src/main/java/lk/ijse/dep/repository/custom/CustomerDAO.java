package lk.ijse.dep.repository.custom;

import lk.ijse.dep.repository.CrudDAO;
import lk.ijse.dep.entity.Customer;

public interface CustomerDAO extends CrudDAO<Customer,String> {

    String getLastCustomerId() throws Exception;

}