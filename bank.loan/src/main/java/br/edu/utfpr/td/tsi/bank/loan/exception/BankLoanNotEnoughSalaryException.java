package br.edu.utfpr.td.tsi.bank.loan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "The given anual salary is incompatible with the minimal requirements")
public class BankLoanNotEnoughSalaryException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public BankLoanNotEnoughSalaryException(){}
    public BankLoanNotEnoughSalaryException(String msg){
        super(msg);
    }
}
