package br.edu.utfpr.td.tsi.bank.loan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "The given values are incorrect. Please Verify")
public class BankLoanIllegalArgumentsException extends RuntimeException{
    public BankLoanIllegalArgumentsException(){}
    public BankLoanIllegalArgumentsException(String msg){
        super(msg);
    }
}
