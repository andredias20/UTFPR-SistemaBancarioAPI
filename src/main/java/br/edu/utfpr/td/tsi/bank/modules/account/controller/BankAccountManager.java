package br.edu.utfpr.td.tsi.bank.modules.account.controller;

import java.util.Date;
import java.util.List;

import br.edu.utfpr.td.tsi.bank.modules.account.dao.BankAccountDAO;
import br.edu.utfpr.td.tsi.bank.modules.account.exceptions.BankAccountNotAllowedException;
import br.edu.utfpr.td.tsi.bank.modules.account.exceptions.BankAccountNotFoundException;
import br.edu.utfpr.td.tsi.bank.modules.account.model.Transaction;
import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.utfpr.td.tsi.bank.modules.account.dao.TransactionDAO;
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
        Client clientID = item.getClient();
        var client = clientManager.searchByCPF(clientID.getCpf());
        if(dao.existsByAccountNumber(item.getAgency(), item.getAccountNumber()).isPresent()) throw new BankAccountNotAllowedException();
        item.setActive(true);
        var finalItem = dao.save(item);
        updateClient(client, finalItem.getId());
        return finalItem;
    }

    private void updateClient(Client item, int accountId) {
        item.setOwnAccountId(accountId);
        clientManager.update(item);
    }

    @Override
    public BankAccount updateAccount(BankAccount item) {
        dao.findById(item.getId())
                .orElseThrow(BankAccountNotFoundException::new);

        return dao.save(item);
    }

    @Override
    public Transaction transfer(Transaction item) {
        var id = item.getAccount().getId();
        listById(id);
        return transDao.save(item);
    }

    @Override
    public Double balance(Integer clientID) {
        return transDao.clientBalance(new BankAccount(clientID));
    }

    @Override
    public List<Transaction> getTransactions(Integer id) {
        List<Transaction> transactions = transDao.listTransactionsByAccountId(new BankAccount(id));
        if(transactions == null) throw new BankAccountNotFoundException();
        return transactions;
    }

    @Override
    public List<Transaction> transactionsByDate(Integer id, Date start, Date end) {
        List<Transaction> transactions = transDao.listTransactionsByDate(new BankAccount(id), start, end);
        if(transactions == null) throw new BankAccountNotFoundException();
        return transactions;
    }

    @Override
    public BankAccount listById(Integer id) {
        return dao.findById(id)
                .orElseThrow(BankAccountNotFoundException::new);
    }

    @Override
    public List<BankAccount> listAll() {
        return dao.searchAll();
    }
}
