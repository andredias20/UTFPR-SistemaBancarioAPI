package br.edu.utfpr.td.tsi.bank.resources;

import java.util.Date;
import java.util.List;

import br.edu.utfpr.td.tsi.bank.modules.account.controller.BankAccountManager;
import br.edu.utfpr.td.tsi.bank.modules.account.model.BankAccount;
import br.edu.utfpr.td.tsi.bank.modules.account.model.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BankAccountResources {

    @Autowired
    BankAccountManager mgr;

    @PostMapping(path = "/bank/account", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BankAccount> openAccount(@RequestBody BankAccount item) {
        BankAccount account = mgr.openAccount(item);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @PutMapping(path = "/bank/account", params = "id")
    public ResponseEntity<BankAccount> updateAccount(@Validated @RequestBody BankAccount item, @RequestParam Integer id){
        item.setId(id);
        BankAccount account = mgr.updateAccount(item);
        return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/bank/account/transaction")
    public ResponseEntity<Transaction> transfer(@Validated @RequestBody Transaction item) {
        Transaction transaction = mgr.transfer(item);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
    @GetMapping(path = "/bank/account/balance", params = "client_id")
    public ResponseEntity<Double> balance(@RequestParam Integer clientId) {
        Double balance = mgr.balance(clientId);
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }

    @GetMapping(path = "/bank/account/transaction", params = "client_id")
    public ResponseEntity<List<Transaction>> getTransactions(@RequestParam Integer client_id) {
        List<Transaction> transactions = mgr.getTransactions(client_id);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping(path = "/bank/account/transaction")
    public ResponseEntity<List<Transaction>> transactionsByDate(Integer client_id, Date start, Date end) {
        List<Transaction> transactions = mgr.transactionsByDate(client_id, start, end);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping(path = "/bank/account", params = "id")
    public ResponseEntity<BankAccount> listById(@RequestParam Integer id) {
        BankAccount account = mgr.listById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping(path = "/bank/account")
    public ResponseEntity<List<BankAccount>> listAll() {
        List<BankAccount> accounts = mgr.listAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
