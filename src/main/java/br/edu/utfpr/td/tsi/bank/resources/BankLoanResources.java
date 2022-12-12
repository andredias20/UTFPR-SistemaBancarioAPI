package br.edu.utfpr.td.tsi.bank.resources;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.utfpr.td.tsi.bank.modules.loan.controller.BankLoanController;
import br.edu.utfpr.td.tsi.bank.modules.loan.model.BankLoan;
import ioinformarics.oss.jackson.module.jsonld.JsonldModule;

@RestController
public class BankLoanResources {

    @Autowired
    BankLoanController mgr;

    private ObjectMapper mapper = new ObjectMapper();

    @PostConstruct
    private void initialize(){
        mapper.registerModule(new JsonldModule());
    }

    @PostMapping(path = "/bank/loan")
    public ResponseEntity<String> create(@Validated @RequestBody BankLoan item) throws JsonProcessingException {
        BankLoan loan = mgr.create(item);
        return new ResponseEntity<>(mapper.writeValueAsString(loan), HttpStatus.CREATED);
    }


    @PutMapping(path = "/bank/loan", params = "id")
    public ResponseEntity<String> update(@RequestBody BankLoan item, @RequestParam(name = "id") Integer id) throws JsonProcessingException {
        BankLoan loan = mgr.update(item, id);
        return new ResponseEntity<>(mapper.writeValueAsString(loan), HttpStatus.ACCEPTED);
    }


    @DeleteMapping(path = "/bank/loan", params = "id")
    public ResponseEntity<BankLoan> delete(@RequestParam(name = "id") Integer id) {
        mgr.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/bank/loan")
    public ResponseEntity<String> listAll() throws JsonProcessingException {
        List<BankLoan> loans = mgr.listAll();
        return new ResponseEntity<>(mapper.writeValueAsString(loans), HttpStatus.OK);
    }

    @GetMapping(path = "/bank/loan", params = "id")
    public ResponseEntity<String> listById(@RequestParam(name = "id") Integer id) throws JsonProcessingException {
        BankLoan loan = mgr.listById(id);
        return new ResponseEntity<>(mapper.writeValueAsString(loan), HttpStatus.OK);
    }
    @GetMapping(path = "/bank/loan/{id}")
    public ResponseEntity<String> listByIdPath(@PathVariable int id) throws JsonProcessingException {
        BankLoan loan = mgr.listById(id);
        return new ResponseEntity<>(mapper.writeValueAsString(loan), HttpStatus.OK);
    }
    @GetMapping(path = "/bank/loan", params = "client_cpf")
    public ResponseEntity<String> listByClientId(@RequestParam(name = "client_cpf") String cpf) throws JsonProcessingException {
        List<BankLoan> loan = mgr.listLoansByClientId(cpf);
        return new ResponseEntity<>(mapper.writeValueAsString(loan), HttpStatus.OK);
    }
}
