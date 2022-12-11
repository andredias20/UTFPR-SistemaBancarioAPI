package br.edu.utfpr.td.tsi.bank.resources;

import java.util.List;

import javax.annotation.PostConstruct;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.utfpr.td.tsi.bank.modules.credit.card.controller.CreditCardController;
import br.edu.utfpr.td.tsi.bank.modules.credit.card.model.CreditCard;
import ioinformarics.oss.jackson.module.jsonld.JsonldModule;

@RestController
public class CreditCardResources {

    @Autowired
    CreditCardController mgr;

    private ObjectMapper mapper = new ObjectMapper();

    @PostConstruct
    private void initialize(){
        mapper.registerModule(new JsonldModule());
    }
    
    @GetMapping(path = "bank/credit-card", produces = "application/json")
    public ResponseEntity<String> listAll() throws JsonProcessingException {
        List<CreditCard> cards = mgr.listAll();
        return new ResponseEntity<>(mapper.writeValueAsString(cards), HttpStatus.OK);
    }

    @GetMapping(value = "/bank/credit-card", params = "id")
    public ResponseEntity<String> listById(@RequestParam Integer id) throws JsonProcessingException {
        CreditCard card = mgr.listById(id);
        return new ResponseEntity<>(mapper.writeValueAsString(card), HttpStatus.OK);
    }
    
    @GetMapping(path = "bank/credit-card", params = "client_id")
    public ResponseEntity<String> listByClientId(@RequestParam(name = "client_id") String id) throws JsonProcessingException{
    	CreditCard card = mgr.listByClient(id);
    	return new ResponseEntity<>(mapper.writeValueAsString(card), HttpStatus.OK);
    }

    @PostMapping(value = "/bank/credit-card")
    public ResponseEntity<String> create(@Validated @RequestBody CreditCard item) throws JsonProcessingException {
        CreditCard card = mgr.create(item);
        return new ResponseEntity<>(mapper.writeValueAsString(card), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/bank/credit-card", params = "id")
    public ResponseEntity<CreditCard> delete(@RequestParam Integer id) {
        mgr.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/bank/credit-card", params = "id")
    public ResponseEntity<String> update(@RequestBody @Validated CreditCard item, @RequestParam Integer id) throws JsonProcessingException {
        CreditCard card = mgr.update(item, id);
        return new ResponseEntity<>(mapper.writeValueAsString(card), HttpStatus.ACCEPTED);
    }
}
