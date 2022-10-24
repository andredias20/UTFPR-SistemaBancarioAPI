package br.edu.utfpr.td.tsi.bank.resources;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import br.edu.utfpr.td.tsi.bank.modules.account.controller.BankAccountManager;
import br.edu.utfpr.td.tsi.bank.modules.account.model.BankAccount;
import br.edu.utfpr.td.tsi.bank.modules.account.model.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
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

    //Account:
    @PostMapping(path = "/bank/account", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BankAccount> openAccount(@Validated @RequestBody BankAccount item) {
        BankAccount account = mgr.openAccount(item);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
    @PutMapping(path = "/bank/account", params = "id")
    public ResponseEntity<BankAccount> updateAccount(@Validated @RequestBody BankAccount item, @RequestParam Integer id){
        item.setId(id);
        BankAccount account = mgr.updateAccount(item);
        return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
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

    //Transactions:
    @PostMapping(path = "/bank/account/transaction")
    public ResponseEntity<Transaction> transfer(@Validated @RequestBody Transaction item) {
        Transaction transaction = mgr.transfer(item);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
    @GetMapping(path = "/bank/account/balance", params = "account_id")
    public ResponseEntity<Double> balance(@RequestParam(name = "account_id") Integer id) {
        Double balance = mgr.balance(id);
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }

    @GetMapping(path = "/bank/account/transaction")
    public ResponseEntity<String> getAllTransactions() {
        return new ResponseEntity<>("Error", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @GetMapping(path = "/bank/account/transaction", params = "account_id")
    public ResponseEntity<List<Transaction>> getTransactions(@RequestParam Integer account_id) {
        List<Transaction> transactions = mgr.getTransactions(account_id);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping(path = "/bank/account/transaction", params = {"account_id", "start", "end"})
    public ResponseEntity<List<Transaction>> transactionsByDate(
            @RequestParam(name = "account_id") Integer id,
            @RequestParam(name = "start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE ) Date start,
            @RequestParam(name = "end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end)
    {
        List<Transaction> transactions = mgr.transactionsByDate(id, start, end);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
