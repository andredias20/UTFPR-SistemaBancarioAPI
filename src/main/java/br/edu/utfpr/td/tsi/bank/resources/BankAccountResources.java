package br.edu.utfpr.td.tsi.bank.resources;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.edu.utfpr.td.tsi.bank.modules.account.controller.BankAccountManager;
import br.edu.utfpr.td.tsi.bank.modules.account.model.BankAccount;
import br.edu.utfpr.td.tsi.bank.modules.account.model.Transaction;
import ioinformarics.oss.jackson.module.jsonld.JsonldModule;


@RestController
public class BankAccountResources {

    @Autowired
    BankAccountManager mgr;

    private ObjectMapper mapper = new ObjectMapper();

    @PostConstruct
    private void initialize(){
        mapper.registerModule(new JsonldModule());
    }

    
    @PostMapping(path = "/bank/account", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> openAccount(@Validated @RequestBody BankAccount item) throws JsonProcessingException {
        BankAccount account = mgr.openAccount(item);
        return new ResponseEntity<>(mapper.writeValueAsString(account), HttpStatus.CREATED);
    }

    @PutMapping(path = "/bank/account", params = "id")
    public ResponseEntity<String> updateAccount(@Validated @RequestBody BankAccount item, @RequestParam Integer id) throws JsonProcessingException{
        item.setId(id);
        BankAccount account = mgr.updateAccount(item);
        return new ResponseEntity<>(mapper.writeValueAsString(account), HttpStatus.ACCEPTED);
    }
    
    @GetMapping(path = "/bank/account", params = "id")
    public ResponseEntity<String> listById(@RequestParam Integer id) throws JsonProcessingException {
        BankAccount account = mgr.listById(id);
        return new ResponseEntity<>(mapper.writeValueAsString(account), HttpStatus.OK);
    }

    @GetMapping(path = "/bank/account")
    public ResponseEntity<String> listAll() throws JsonProcessingException {
        List<BankAccount> accounts = mgr.listAll();
        return new ResponseEntity<>(mapper.writeValueAsString(accounts), HttpStatus.OK);
    }

    //Transactions:
    @PostMapping(path = "/bank/account/transaction")
    public ResponseEntity<String> transfer(@Validated @RequestBody Transaction item) throws JsonProcessingException {
        Transaction transaction = mgr.transfer(item);
        return new ResponseEntity<>(mapper.writeValueAsString(transaction), HttpStatus.CREATED);
    }
    @GetMapping(path = "/bank/account/balance", params = "account_id")
    public ResponseEntity<String> balance(@RequestParam(name = "account_id") Integer id) throws JsonProcessingException {
        Double balance = mgr.balance(id);
        ObjectMapper creator = new ObjectMapper();
        ObjectNode json = creator.createObjectNode();
        json.put("balance", balance);
        return new ResponseEntity<>(mapper.writeValueAsString(json), HttpStatus.OK);
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
    public ResponseEntity<String> transactionsByDate(
            @RequestParam(name = "account_id") Integer id,
            @RequestParam(name = "start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE ) Date start,
            @RequestParam(name = "end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end) throws JsonProcessingException
    {
        List<Transaction> transactions = mgr.transactionsByDate(id, start, end);
        return new ResponseEntity<>(mapper.writeValueAsString(transactions), HttpStatus.OK);
    }
}
