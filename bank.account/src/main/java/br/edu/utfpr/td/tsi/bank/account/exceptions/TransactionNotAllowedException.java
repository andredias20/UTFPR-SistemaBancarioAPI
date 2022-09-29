package br.edu.utfpr.td.tsi.bank.account.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "The provided BankAccount isn't active. Please Verify")
public class TransactionNotAllowedException extends RuntimeException {
    public TransactionNotAllowedException(){}

    public TransactionNotAllowedException(String msg){super(msg);}
}
