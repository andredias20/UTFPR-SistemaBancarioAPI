package br.edu.utfpr.td.tsi.bank.account.controller;

import br.edu.utfpr.td.tsi.bank.account.model.*;

import java.util.List;

public interface BankAccountController {

    void openAccount();
    void transfer();
    Double balance(Integer clientID);
    List<Transaction> getTransactions();
    List<Transaction> transactionsByDate();
    BankAccount listById(Integer id);
    List<BankAccount> listAll();



}
