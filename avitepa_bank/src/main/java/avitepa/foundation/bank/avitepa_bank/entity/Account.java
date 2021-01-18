/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avitepa.foundation.bank.avitepa_bank.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Shubham
 */

@Entity
@Table(name="account")
public class Account {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="account_no")
    private int accountNo;
    
    @Column(name="account_type")
    private String accountType;
    
    @Column(name="balance")
    private double balance;
    
    @ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="customer_account",
            joinColumns=@JoinColumn(name="account_no"),
            inverseJoinColumns=@JoinColumn(name="customer_id")
                )
    private List<Customer> customers;

    @Transient
    private String result;
    
    public Account() {
    }

    public Account(String accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    
   

    @Override
    public String toString() {
        return "Account{" + "accountNo=" + accountNo + ", accountType=" + accountType + ", balance=" + balance + ", result=" + result + '}';
    }
 
    
    public void addCustomer(Customer tempCustomer)
    {
        if(customers==null)
            customers=new ArrayList<>();
        customers.add(tempCustomer);
    }
}
