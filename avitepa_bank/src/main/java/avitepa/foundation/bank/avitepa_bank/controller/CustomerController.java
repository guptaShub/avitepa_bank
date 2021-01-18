/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avitepa.foundation.bank.avitepa_bank.controller;

import avitepa.foundation.bank.avitepa_bank.entity.Account;
import avitepa.foundation.bank.avitepa_bank.entity.Customer;
import avitepa.foundation.bank.avitepa_bank.exception.CustomerNotFoundException;
import avitepa.foundation.bank.avitepa_bank.service.AccountService;
import avitepa.foundation.bank.avitepa_bank.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Shubham
 */

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public List<Customer> getAllCustomers(){
        List<Customer> list=customerService.getAllCustomers();
        if(list==null)
            return null;
        return list;
    }
    
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id)
    {
        Customer customer=customerService.getCustomer(id);
        if(customer==null)
        {
            customer=new Customer();
            customer.setResult("Error 404 Customer Not Found");
            throw new CustomerNotFoundException("Customer not found - "+id);
        }
        return customer;
    }
    
    @PostMapping("/")
    public Customer saveCustomer(@RequestBody Customer customer)
    {
        try{
        customerService.saveCustomer(customer);
        customer.setResult("Customer Saved Successfully");
        }catch(Exception e)
        {
            customer.setResult("Customer not Saved");
        }
        return customer;
    }
    
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id,@RequestBody Customer customer)
    {
        try{
            if(customer.getCustomerId()!=id)
            {
                Customer c=new Customer();
                c.setResult("Customer Id not matched");
                return c;
            }
            
        customerService.updateCustomer(id, customer);
        customer.setResult("Customer Updated Successfully");
        }catch(Exception e)
        {
            customer.setResult("Customer not updated");
        }
        return customer;
    }
    
    
    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable int id)
    {
        Customer customer=new Customer();
        try{
        customerService.deleteCustomer(id);
        customer.setResult("Customer Deleted Successfully");
        }catch(Exception e)
        {
            customer.setResult("Customer not deleted");
        }
        return customer;
    }
    
    @PostMapping("/{id}/accounts")
    public Customer createAccount(@PathVariable int id,@RequestBody Account account)
    {
        Customer customer=customerService.getCustomer(id);
        customer.addAccount(account);
        
        accountService.saveAccount(account);
        
        customer.setResult("Account Created");
        
        return customer;
    }
    
    
}
