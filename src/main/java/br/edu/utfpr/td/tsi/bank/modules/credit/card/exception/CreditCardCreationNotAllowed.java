package br.edu.utfpr.td.tsi.bank.modules.credit.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "A client can't have more than one CreditCard")
public class CreditCardCreationNotAllowed extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CreditCardCreationNotAllowed(){}
    public CreditCardCreationNotAllowed(String msg){
        super(msg);
    }
}
