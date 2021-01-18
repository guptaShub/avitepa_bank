/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avitepa.foundation.bank.avitepa_bank.dao;

import avitepa.foundation.bank.avitepa_bank.entity.Account;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Shubham
 */

@Repository
public class AccountDaoImpl implements AccountDao{

    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<Account> getAllAccounts() {
        
        Session session=entityManager.unwrap(Session.class);
        Query<Account> query=session.createQuery("from Account",Account.class);
        List<Account> list=query.getResultList();
        return list;
    }

    @Override
    public Account getAccount(int accountNo) {
        
        Session session=entityManager.unwrap(Session.class);
        Account account=session.get(Account.class,accountNo);
        return account;
    }

    @Override
    public void saveAccount(Account account) {

        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(account);
        
    }

    @Override
    public void deleteAccount(int accountNo) {

        Session session=entityManager.unwrap(Session.class);
        session.delete(session.get(Account.class,accountNo));
        
    }

    @Override
    public void updateAccount(int accountNo, Account account) {

        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(account);
    }
 
}
