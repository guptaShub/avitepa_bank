/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avitepa.foundation.bank.avitepa_bank.controller;

import avitepa.foundation.bank.avitepa_bank.entity.Account;
import avitepa.foundation.bank.avitepa_bank.entity.TransferFund;
import avitepa.foundation.bank.avitepa_bank.service.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Shubham
 */

@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }
    
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable int id)
    {
        Account account=accountService.getAccount(id);
        if(account==null)
        {
            account.setResult("Account not found");
        }
        account.setResult("Account founded");
        return account;
    }
    
    @PutMapping("/transferFund")
    public TransferFund transferFund(@RequestBody TransferFund transfer)
    {
        TransferFund transferFund=accountService.transferFund(transfer);
        return transferFund;
    }

}
