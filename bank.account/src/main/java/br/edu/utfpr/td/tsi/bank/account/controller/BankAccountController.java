package br.edu.utfpr.td.tsi.bank.account.controller;

import br.edu.utfpr.td.tsi.bank.account.model.*;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.Date;
import java.util.List;

public interface BankAccountController {
    BankAccount openAccount(BankAccount item);
    Transaction transfer(Transaction item);
    Double balance(Integer clientID);
    List<Transaction> getTransactions(Integer client_id);
    List<Transaction> transactionsByDate(BankAccount bank, Date start, Date end);
    BankAccount listById(Integer id);
    List<BankAccount> listAll();

}
