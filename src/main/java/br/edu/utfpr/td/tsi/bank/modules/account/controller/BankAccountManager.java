package br.edu.utfpr.td.tsi.bank.modules.account.controller;

import java.util.Date;
import java.util.List;

import br.edu.utfpr.td.tsi.bank.modules.account.dao.BankAccountDAO;
import br.edu.utfpr.td.tsi.bank.modules.account.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.utfpr.td.tsi.bank.modules.account.dao.TransactionDAO;
import br.edu.utfpr.td.tsi.bank.account.exceptions.BankAccountNotAllowedException;
import br.edu.utfpr.td.tsi.bank.account.exceptions.BankAccountNotFoundException;
import br.edu.utfpr.td.tsi.bank.modules.client.controller.ClientManager;
import br.edu.utfpr.td.tsi.bank.modules.account.model.BankAccount;

@Controller
public class BankAccountManager implements BankAccountController {

	@Autowired
    private BankAccountDAO dao;
	@Autowired
    private TransactionDAO transDao;
	@Autowired
    private ClientManager clientManager;


	@Override
    public BankAccount openAccount(BankAccount item) {

        var clientID = item.getClient();
        clientManager.searchById(clientID.getId());

        BankAccount exists = dao.existsByAccountNumber(item.getAgency(), item.getAccountNumber());

        if(exists != null) throw new BankAccountNotAllowedException();
        item.setActive(true);
        return dao.save(item);
    }

    @Override
    public BankAccount updateAccount(BankAccount item) {
        BankAccount account = dao
                .findById(item.getId())
                .orElseThrow(BankAccountNotFoundException::new);

        return dao.save(item);
    }

    @Override
    public Transaction transfer(Transaction item) {
        item.getClient().getId();
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
