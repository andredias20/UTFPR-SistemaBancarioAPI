package br.edu.utfpr.td.tsi.bank.account.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "The given account is already in use")
public class BankAccountNotAllowedException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BankAccountNotAllowedException(){}

    public BankAccountNotAllowedException(String msg){
        super(msg);
    }

}
