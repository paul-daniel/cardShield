package com.PaulDanielT.cardShield.dao.customer;

import com.PaulDanielT.cardShield.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jdbc")
public class CustomerDao implements ICustomerDao{
    @Override
    public List<Customer> selectAllCustomers() {
        return null;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void insertCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomerById(Integer id) {

    }

    @Override
    public void updateCustomerInfos(Customer customer) {

    }

    @Override
    public boolean existsCustomerWithId(Integer id) {
        return false;
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return false;
    }
}
