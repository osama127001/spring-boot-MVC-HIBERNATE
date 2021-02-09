package com.osama.mvcandhibernate.dao;

import com.osama.mvcandhibernate.dao.interfaces.ICustomerDao;
import com.osama.mvcandhibernate.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class CustomerDao implements ICustomerDao {

    private JdbcTemplate jdbcTemplate;


    /*
     * Creating Session Factory */
    private SessionFactory sessionFactory;


    /*
    * Injecting Session Factory
    * Constructor Injection */
    @Autowired
    public CustomerDao(EntityManagerFactory factory, JdbcTemplate jdbcTemplate) {
        this.sessionFactory = factory.unwrap(SessionFactory.class);
        this.jdbcTemplate = jdbcTemplate;
    }



    /*
    * The @Transactional Annotation removes the use of:
    * "session.getTransaction().commit()" and "session.startTransaction" */
    @Override
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.openSession();

        /*
        * Import Query from "org.hibernate.query.Query;" */
        // Query<Customer> query = currentSession.createQuery("FROM Customer ORDER BY lastName", Customer.class);
        int id = 1;
        return jdbcTemplate.query("SELECT * FROM customer WHERE id = ?"
                , new Object[]{id}
                , new BeanPropertyRowMapper(Customer.class));

//        return query.getResultList();
    }


    /*
    * Adding Customer in the Database*/
    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.openSession();
        currentSession.saveOrUpdate(customer);
    }


    /*
    * Get customer from DB based on the id */
    @Override
    public Customer getCustomer(int id) {
        Session currentSession = sessionFactory.openSession();
        Customer customer = currentSession.get(Customer.class, id);
        return customer;
    }

    /*
    * Delete Customer from DB */
    @Override
    public void deleteCustomer(Customer customer) {
        Session currentSession = sessionFactory.openSession();
        currentSession.remove(customer);
    }


}
