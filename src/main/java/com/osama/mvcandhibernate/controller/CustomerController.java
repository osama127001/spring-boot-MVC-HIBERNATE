package com.osama.mvcandhibernate.controller;

import com.osama.mvcandhibernate.dao.CustomerDao;
import com.osama.mvcandhibernate.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerDao customerDao;


    /*
     * Injecting the Customer-DAO class
     * Using Field Injection */
    @Autowired
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    //    /*
//    * GET:
//    * Returns all customers */
//    @RequestMapping(path = "/list", method = RequestMethod.GET)
//    public String listCustomers(Model model) {
//        List<Customer> customers = customerDao.getCustomers();
//        model.addAttribute("customers", customers);
//        return "list-customers";
//    }

}
