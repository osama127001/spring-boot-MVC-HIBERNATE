package com.osama.mvcandhibernate.service.interfaces;

import com.osama.mvcandhibernate.model.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> getCustomers();

    public Customer getCustomer(int id);

    public void saveCustomer(Customer customer);

    public void deleteCustomer(int id);

}
