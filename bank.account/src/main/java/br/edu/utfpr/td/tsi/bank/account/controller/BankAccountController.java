package br.edu.utfpr.td.tsi.bank.account.controller;

import br.edu.utfpr.td.tsi.bank.account.model.BankAccount;
import br.edu.utfpr.td.tsi.bank.account.model.Transaction;

import java.util.Date;
import java.util.List;


public interface BankAccountController {
    BankAccount openAccount(BankAccount item);
    BankAccount updateAccount(BankAccount item);
    Transaction transfer(Transaction item);
    Double balance(Integer clientID);
    List<Transaction> getTransactions(Integer client_id);
    List<Transaction> transactionsByDate(Integer client_id, Date start, Date end);
    BankAccount listById(Integer id);
    List<BankAccount> listAll();

}
