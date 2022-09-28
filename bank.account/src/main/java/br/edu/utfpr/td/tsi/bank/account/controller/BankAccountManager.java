package br.edu.utfpr.td.tsi.bank.account.controller;

import br.edu.utfpr.td.tsi.bank.account.dao.BankAccountDAO;
import br.edu.utfpr.td.tsi.bank.account.dao.TransactionDAO;
import br.edu.utfpr.td.tsi.bank.account.model.BankAccount;
import br.edu.utfpr.td.tsi.bank.account.model.Transaction;
import br.edu.utfpr.td.tsi.bank.client.controller.ClientManager;
import br.edu.utfpr.td.tsi.bank.client.model.Client;

import java.util.Date;
import java.util.List;

public class BankAccountManager implements BankAccountController{


    BankAccountDAO bankAccountDAO;
    TransactionDAO transactionDAO;
    ClientManager clientManager;

    @Override
    public void openAccount(BankAccount item) {
        Client client = clientManager.searchById(item.getClient());
        boolean alreadyExists = bankAccountDAO.existsByAccountNumber(item.getAgency(), item.getAccountNumber());

            if (client != null && !alreadyExists) {
                bankAccountDAO.save(item);
            }

    }

    @Override
    public void transfer(Transaction item) {

    }

    @Override
    public Double balance(Integer clientID) {
        return null;
    }

    @Override
    public List<Transaction> getTransactions(Integer bank_id) {
        return null;
    }

    @Override
    public List<Transaction> transactionsByDate(BankAccount bank, Date start, Date end) {
        return null;
    }

    @Override
    public BankAccount listById(Integer id) {
        return null;
    }

    @Override
    public List<BankAccount> listAll() {
        return null;
    }
}
