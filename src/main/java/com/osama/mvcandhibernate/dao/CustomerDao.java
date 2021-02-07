package com.osama.mvcandhibernate.dao;

import com.osama.mvcandhibernate.dao.interfaces.ICustomerDao;
import com.osama.mvcandhibernate.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDao implements ICustomerDao {

    public CustomerDao() {}


    /*
     * Creating Session Factory */
    private SessionFactory sessionFactory;


    @Autowired
    public CustomerDao(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }



    /*
    * The @Transactional Annotation removes the use of:
    * "session.getTransaction().commit()" and "session.startTransaction" */
    @Override
    @Transactional
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.openSession();

        /*
        * Import Query from "org.hibernate.query.Query;" */
        Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);

        return query.getResultList();
    }

}
