package com.osama.mvcandhibernate.dao.interfaces;

import com.osama.mvcandhibernate.model.Customer;

import java.util.List;

public interface ICustomerDao {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int id);

}
