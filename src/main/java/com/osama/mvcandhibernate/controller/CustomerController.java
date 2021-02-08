package com.osama.mvcandhibernate.controller;

import com.osama.mvcandhibernate.dao.CustomerDao;
import com.osama.mvcandhibernate.model.Customer;
import com.osama.mvcandhibernate.service.CustomerService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;


    /*
     * Injecting the Customer-DAO class
     * Using Constructor Injection */
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    /*
     * GET:
     * Returns all customers */
    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "list-customers";
    }


    /*
    * Redirecting the user to a form to add Customer */
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }


    /*
    * POST:
    * Add customer in the database */
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }


    /*
     * Redirecting the user to a form to update Customer */
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);
        return "customer-form";
    }
}
