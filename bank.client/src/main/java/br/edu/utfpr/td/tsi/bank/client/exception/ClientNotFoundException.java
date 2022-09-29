package br.edu.utfpr.td.tsi.bank.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The given Id/CPF/Name was not found in the database")
public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(){}

    public ClientNotFoundException(String message){
        super(message);
    }

}
