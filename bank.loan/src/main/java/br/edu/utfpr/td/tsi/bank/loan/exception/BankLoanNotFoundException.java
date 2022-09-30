package br.edu.utfpr.td.tsi.bank.loan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BankLoanNotFoundException extends RuntimeException{

    public BankLoanNotFoundException(){}
    public BankLoanNotFoundException(String msg){super(msg);}
}
