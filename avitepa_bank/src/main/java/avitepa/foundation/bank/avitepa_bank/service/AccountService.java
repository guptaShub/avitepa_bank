/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avitepa.foundation.bank.avitepa_bank.service;

import avitepa.foundation.bank.avitepa_bank.entity.Account;
import avitepa.foundation.bank.avitepa_bank.entity.TransferFund;
import java.util.List;

/**
 *
 * @author Shubham
 */
public interface AccountService {
    
   public List<Account> getAllAccounts();
    
    public Account getAccount(int accountNo);
    
    public void saveAccount(Account account);
    
    public void deleteAccount(int accountNo);
    
    public void updateAccount(int accountNo,Account account);
    
    public TransferFund transferFund(TransferFund transfer);
    
}
