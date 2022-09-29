package br.edu.utfpr.td.tsi.bank.account.controller;

import br.edu.utfpr.td.tsi.bank.account.dao.BankAccountDAO;
import br.edu.utfpr.td.tsi.bank.account.dao.TransactionDAO;
import br.edu.utfpr.td.tsi.bank.account.exceptions.BankAccountNotAllowedException;
import br.edu.utfpr.td.tsi.bank.account.exceptions.BankAccountNotFoundException;
import br.edu.utfpr.td.tsi.bank.account.model.BankAccount;
import br.edu.utfpr.td.tsi.bank.account.model.Transaction;
import br.edu.utfpr.td.tsi.bank.client.controller.ClientManager;
import br.edu.utfpr.td.tsi.bank.client.model.Client;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BankAccountManager implements BankAccountController {


    @Autowired
    BankAccountDAO dao;
    @Autowired
    TransactionDAO transDao;
    @Autowired
    ClientManager clientManager;

    @Override
    public BankAccount openAccount(BankAccount item) {
        Client client = clientManager.searchById(item.getClient());
        BankAccount exists = dao.existsByAccountNumber(item.getAgency(), item.getAccountNumber());
        if(exists != null) throw new BankAccountNotAllowedException();
        if(!exists.isActive()){
            exists.setActive(true);
            return dao.save(exists);
        }
        return dao.save(item);
    }

    @Override
    public BankAccount updateAccount(BankAccount item) {
        if(dao.existsById(item.getId())){
            return dao.save(item);
        }else {
            throw new BankAccountNotFoundException();
        }
    }

    @Override
    public Transaction transfer(Transaction item) {
        item.getClientId();
        return transDao.save(item);
    }

    @Override
    public Double balance(Integer clientID) {
        return transDao.clientBalance(clientID);
    }

    @Override
    public List<Transaction> getTransactions(Integer client_id) {
        List<Transaction> transactions = transDao.listTransactionsByClientId(client_id);
        if(transactions == null) throw new BankAccountNotFoundException();
        return transactions;
    }

    @Override
    public List<Transaction> transactionsByDate(Integer client_id, Date start, Date end) {
        List<Transaction> transactions = transDao.listTransactionsByDate(client_id, start, end);
        if(transactions == null) throw new BankAccountNotFoundException();
        return transactions;
    }

    @Override
    public BankAccount listById(Integer id) {
        return dao.findById(id).orElseThrow(BankAccountNotFoundException::new);
    }

    @Override
    public List<BankAccount> listAll() {
        return dao.searchAll();
    }
}
