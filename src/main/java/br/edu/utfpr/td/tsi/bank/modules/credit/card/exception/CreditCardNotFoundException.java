package br.edu.utfpr.td.tsi.bank.modules.credit.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cannot found a Credit Card with the given information")
public class CreditCardNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CreditCardNotFoundException(){}
    public CreditCardNotFoundException(String msg){
        super(msg);
    }
}
