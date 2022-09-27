package br.edu.utfpr.td.tsi.bank.account.controller;

import br.edu.utfpr.td.tsi.bank.account.model.*;

import java.util.Date;
import java.util.List;

public interface BankAccountController {
    void openAccount(BankAccount item);
    void transfer(Transaction item);
    Double balance(Integer clientID);
    List<Transaction> getTransactions(Integer bank_id);
    List<Transaction> transactionsByDate(BankAccount bank, Date start, Date end);
    BankAccount listById(Integer id);
    List<BankAccount> listAll();

}
