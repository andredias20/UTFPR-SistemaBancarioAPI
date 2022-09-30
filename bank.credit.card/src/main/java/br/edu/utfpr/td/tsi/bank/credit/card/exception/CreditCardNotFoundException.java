package br.edu.utfpr.td.tsi.bank.credit.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cannot found a Credit Card with the given information")
public class CreditCardNotFoundException extends RuntimeException{
    public CreditCardNotFoundException(){}
    public CreditCardNotFoundException(String msg){
        super(msg);
    }
}
