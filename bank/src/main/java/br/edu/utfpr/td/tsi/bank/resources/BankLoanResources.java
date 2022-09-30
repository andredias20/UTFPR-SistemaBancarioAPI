package br.edu.utfpr.td.tsi.bank.resources;

import br.edu.utfpr.td.tsi.bank.loan.controller.BankLoanController;
import br.edu.utfpr.td.tsi.bank.loan.model.BankLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<BankLoan> update(@RequestBody BankLoan item, @RequestParam Integer id) {
        item.setId(id);
        BankLoan loan = mgr.create(item);
        return new ResponseEntity<>(loan, HttpStatus.ACCEPTED);
    }


    @DeleteMapping(path = "/bank/loan", params = "id")
    public ResponseEntity<BankLoan> delete(@RequestParam Integer id) {
        mgr.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/bank/loan")
    public ResponseEntity<List<BankLoan>> listAll() {
        List<BankLoan> loans = mgr.listAll();
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @GetMapping(path = "/bank/loan", params = "id")
    public ResponseEntity<BankLoan> listById(@RequestParam Integer id) {
        BankLoan loan = mgr.listById(id);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }
}
