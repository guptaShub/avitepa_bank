/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avitepa.foundation.bank.avitepa_bank.exception;

import avitepa.foundation.bank.avitepa_bank.entity.CustomerErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Shubham
 */

@ControllerAdvice
public class CustomerRestExceptionHandler {
    
    
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc)
    {
        CustomerErrorResponse error=new CustomerErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
