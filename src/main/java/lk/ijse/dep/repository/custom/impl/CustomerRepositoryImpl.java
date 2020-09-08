package lk.ijse.dep.repository.custom.impl;

import lk.ijse.dep.repository.CrudDAOImpl;
import lk.ijse.dep.repository.custom.CustomerRepository;
import lk.ijse.dep.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class CustomerRepositoryImpl extends CrudDAOImpl<Customer, String> implements CustomerRepository {


    @Override
    public String getLastCustomerId() throws Exception {
        try {
            return (String) entityManager.createNativeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1").getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

}
