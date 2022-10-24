package br.edu.utfpr.td.tsi.bank.modules.account.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Was not possible to find an Bank Account with the given data (ID, CPF, Name)")
public class BankAccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BankAccountNotFoundException(){}

    public BankAccountNotFoundException(String msg){
        super(msg);
    }

}
