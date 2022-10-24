package br.edu.utfpr.td.tsi.bank.modules.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "The given Salary is not allowed according to our policies")
public class ClientSalaryNotApplicable extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClientSalaryNotApplicable(){}

    public ClientSalaryNotApplicable(String message){
        super(message);
    }
}
