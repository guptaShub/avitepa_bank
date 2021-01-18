/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avitepa.foundation.bank.avitepa_bank.service;

import avitepa.foundation.bank.avitepa_bank.dao.CustomerDao;
import avitepa.foundation.bank.avitepa_bank.entity.Customer;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Shubham
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    
    @Override
    @Transactional
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    @Transactional
    public Customer getCustomer(int customerId) {
        return customerDao.getCustomer(customerId);
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId) {
        customerDao.deleteCustomer(customerId);
    }

    @Override
    @Transactional
    public void updateCustomer(int customerId, Customer customer) {
        customerDao.updateCustomer(customerId, customer);
    }
    
}
