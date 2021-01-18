/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avitepa.foundation.bank.avitepa_bank.service;

import avitepa.foundation.bank.avitepa_bank.dao.AccountDao;
import avitepa.foundation.bank.avitepa_bank.entity.Account;
import avitepa.foundation.bank.avitepa_bank.entity.TransferFund;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Shubham
 */
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountDao accountDao;
    
    
    @Override
    @Transactional
    public List<Account> getAllAccounts() {
        return accountDao.getAllAccounts();
    }

    @Override
    @Transactional
    public Account getAccount(int accountNo) {
        return accountDao.getAccount(accountNo);
    }

    @Override
    @Transactional
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    @Transactional
    public void deleteAccount(int accountNo) {
        accountDao.deleteAccount(accountNo);
    }

    @Override
    @Transactional
    public void updateAccount(int accountNo, Account account) {
        accountDao.updateAccount(accountNo, account);
    }

    @Override
    @Transactional
    public TransferFund transferFund(TransferFund transfer) {
       
        int fromAccountId=transfer.getFromAccount();
        int toAccountId=transfer.getToAccount();
        
        Account fromAccount=accountDao.getAccount(fromAccountId);
        Account toAccount=accountDao.getAccount(toAccountId);
        
        if(transfer.getAmount()<=fromAccount.getBalance())
        {
            fromAccount.setBalance(fromAccount.getBalance()-transfer.getAmount());
            toAccount.setBalance(toAccount.getBalance()+transfer.getAmount());
            transfer.setResult("Transaction Successful");
        }
        else
        transfer.setResult("Insufficient funds");
        return transfer;
    }
    
}
