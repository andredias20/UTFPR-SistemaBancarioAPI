package br.edu.utfpr.td.tsi.bank.client.exceptions;

public class ClientExceptionRevenue extends Exception {


	private static final long serialVersionUID = 1L;
	
	private String message;

    public ClientExceptionRevenue(String str){
        message = "Client rules not respected: "+str;
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
