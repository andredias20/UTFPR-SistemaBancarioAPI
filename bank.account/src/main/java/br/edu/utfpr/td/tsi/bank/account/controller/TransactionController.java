package br.edu.utfpr.td.tsi.bank.account.controller;

import br.edu.utfpr.td.tsi.bank.account.model.Transaction;

import java.util.List;

public interface TransactionController {

    void register(Transaction item);
    Transaction listById(Integer id);
    List<Transaction> listAll();


}
