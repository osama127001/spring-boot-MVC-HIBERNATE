package com.osama.mvcandhibernate.dao;

import com.osama.mvcandhibernate.dao.interfaces.ICustomerDao;
import com.osama.mvcandhibernate.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDao implements ICustomerDao {

    /*
    * Injecting the Hibernate Session Factory
    * Using Field Injection*/
    @Autowired
    private SessionFactory sessionFactory;


    /*
    * The @Transactional Annotation removes the use of:
    * "session.getTransaction().commit()" and "session.startTransaction" */
    @Override
    @Transactional
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();

        /*
        * Import Query from "org.hibernate.query.Query;" */
        Query<Customer> query = currentSession.createQuery("from customer", Customer.class);

        return query.getResultList();
    }

}
