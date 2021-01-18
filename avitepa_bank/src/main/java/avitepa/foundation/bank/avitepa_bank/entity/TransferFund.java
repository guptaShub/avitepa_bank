/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avitepa.foundation.bank.avitepa_bank.entity;

/**
 *
 * @author Shubham
 */
public class TransferFund {
    
    private int fromAccount;
    
    private int toAccount;
    
    private double amount;
    
    private String result;

    public TransferFund(int fromAccount, int toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    

    public TransferFund() {
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
    }

    public int getToAccount() {
        return toAccount;
    }

    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TransferFund{" + "fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", amount=" + amount + ", result=" + result + '}';
    }

    
    
    
    
}
