package br.edu.utfpr.td.tsi.bank.modules.loan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "The given values are incorrect. Please Verify")
public class BankLoanIllegalArgumentsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public BankLoanIllegalArgumentsException(){}
    public BankLoanIllegalArgumentsException(String msg){
        super(msg);
    }
}
