package com.osama.mvcandhibernate.service.interfaces;

import com.osama.mvcandhibernate.model.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);
}
