package br.edu.utfpr.td.tsi.bank.credit.card.exception;

public class CreditCardNotFoundException extends RuntimeException{
    public CreditCardNotFoundException(){}
    public CreditCardNotFoundException(String msg){
        super(msg);
    }
}
