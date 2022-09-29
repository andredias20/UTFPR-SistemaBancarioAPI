package br.edu.utfpr.td.tsi.bank.account.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Was not possible to find an Object with the given data")
public class BankAccountNotFoundException extends RuntimeException {
    public BankAccountNotFoundException(){}

    public BankAccountNotFoundException(String msg){
        super(msg);
    }

}
