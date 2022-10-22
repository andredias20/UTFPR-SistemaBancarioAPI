package br.edu.utfpr.td.tsi.bank.modules.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The client ID can't be null")
public class ClientCantBeNull extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ClientCantBeNull(){}

    public ClientCantBeNull(String message){
        super(message);
    }

}
