package br.edu.utfpr.td.tsi.bank.credit.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "The given data is invalid, please check.")
public class CreditCardInvalidArgumentsException extends RuntimeException{

    public CreditCardInvalidArgumentsException(){}
    public CreditCardInvalidArgumentsException(String msg){super(msg);}
}
