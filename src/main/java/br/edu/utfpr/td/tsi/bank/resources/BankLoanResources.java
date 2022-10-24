package br.edu.utfpr.td.tsi.bank.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.td.tsi.bank.modules.loan.controller.BankLoanController;
import br.edu.utfpr.td.tsi.bank.modules.loan.model.BankLoan;

@RestController
public class BankLoanResources {
    @Autowired
    BankLoanController mgr;

    @PostMapping(path = "/bank/loan")
    public ResponseEntity<BankLoan> create(@Validated @RequestBody BankLoan item) {
        BankLoan loan = mgr.create(item);
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }


    @PutMapping(path = "/bank/loan", params = "id")
    public ResponseEntity<BankLoan> update(@RequestBody BankLoan item, @RequestParam(name = "id") Integer id) {
        BankLoan loan = mgr.update(item, id);
        return new ResponseEntity<>(loan, HttpStatus.ACCEPTED);
    }


    @DeleteMapping(path = "/bank/loan", params = "id")
    public ResponseEntity<BankLoan> delete(@RequestParam(name = "id") Integer id) {
        mgr.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/bank/loan")
    public ResponseEntity<List<BankLoan>> listAll() {
        List<BankLoan> loans = mgr.listAll();
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @GetMapping(path = "/bank/loan", params = "id")
    public ResponseEntity<BankLoan> listById(@RequestParam(name = "id") Integer id) {
        BankLoan loan = mgr.listById(id);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }
    @GetMapping(path = "/bank/loan", params = "client_id")
    public ResponseEntity<List<BankLoan>> listByClientId(@RequestParam(name = "client_id") Integer id) {
        List<BankLoan> loan = mgr.listLoansByClientId(id);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }
}
