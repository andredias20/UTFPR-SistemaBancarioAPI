package br.edu.utfpr.td.tsi.bank.modules.account.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "The provided BankAccount isn't active. Please Verify")
public class TransactionNotAllowedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TransactionNotAllowedException(){}

    public TransactionNotAllowedException(String msg){super(msg);}
}
