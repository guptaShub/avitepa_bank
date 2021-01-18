/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avitepa.foundation.bank.avitepa_bank.dao;

import avitepa.foundation.bank.avitepa_bank.entity.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Shubham
 */
@Repository
public class CustomerDaoImpl implements CustomerDao{

   @Autowired
    private EntityManager entityManager;
   
   
   
    @Override
    public List<Customer> getAllCustomers() {
    
        Session session=entityManager.unwrap(Session.class);
        
        Query<Customer> query=session.createQuery("from Customer",Customer.class);
        
        List<Customer> customers=query.getResultList();
        
        return customers;
        
    }

    @Override
    public Customer getCustomer(int customerId) {
        
        Session session=entityManager.unwrap(Session.class);
        Customer customer=session.get(Customer.class,customerId);
        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {
        
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {

        Session session=entityManager.unwrap(Session.class);
        session.delete(session.get(Customer.class,customerId));
    }

    @Override
    public void updateCustomer(int customerId, Customer customer) {

        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(customer);
    }
    
    
}
