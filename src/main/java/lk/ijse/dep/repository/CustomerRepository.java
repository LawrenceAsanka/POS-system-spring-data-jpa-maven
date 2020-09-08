package lk.ijse.dep.repository;

import lk.ijse.dep.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {

    String getLastCustomerId() throws Exception;

}
