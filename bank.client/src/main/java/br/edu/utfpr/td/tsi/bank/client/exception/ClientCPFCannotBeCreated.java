package br.edu.utfpr.td.tsi.bank.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "The given CPF aready exists in the base")
public class ClientCPFCannotBeCreated extends RuntimeException {
    public ClientCPFCannotBeCreated(){}

    public ClientCPFCannotBeCreated(String message){
        super(message);
    }
}
