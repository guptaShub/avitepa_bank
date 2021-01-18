/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avitepa.foundation.bank.avitepa_bank.service;

import avitepa.foundation.bank.avitepa_bank.entity.Customer;
import java.util.List;

/**
 *
 * @author Shubham
 */
public interface CustomerService {
    
     public List<Customer> getAllCustomers();
    
    public Customer getCustomer(int customerId);
    
    public void saveCustomer(Customer customer);
    
    public void deleteCustomer(int customerId);
    
    public void updateCustomer(int customerId,Customer customer);
}
