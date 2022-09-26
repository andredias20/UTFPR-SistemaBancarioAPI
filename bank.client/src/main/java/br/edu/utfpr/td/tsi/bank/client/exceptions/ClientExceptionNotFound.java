package br.edu.utfpr.td.tsi.bank.client.exceptions;

public class ClientExceptionNotFound extends Exception {


	private static final long serialVersionUID = 1L;
	
	private String message;

    public ClientExceptionNotFound(String str){
        message = "Client: "+str;
    }

    @Override
    public String getMessage(){
        return message;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
