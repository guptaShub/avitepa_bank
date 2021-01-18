/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avitepa.foundation.bank.avitepa_bank.exception;

/**
 *
 * @author Shubham
 */
public class CustomerNotFoundException extends RuntimeException{
    
    public CustomerNotFoundException(String message)
    {
        super(message);
    }
    
}
