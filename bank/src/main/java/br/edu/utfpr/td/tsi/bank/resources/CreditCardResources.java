package br.edu.utfpr.td.tsi.bank.resources;

import br.edu.utfpr.td.tsi.bank.credit.card.controller.CreditCardController;
import br.edu.utfpr.td.tsi.bank.credit.card.model.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CreditCardResources {

    @Autowired
    CreditCardController mgr;
    @GetMapping(path = "bank/credit-card")
    public ResponseEntity<List<CreditCard>> listAll() {
        List<CreditCard> cards = mgr.listAll();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping(value = "/bank/credit-card", params = "id")
    public ResponseEntity<CreditCard> listById(@RequestParam Integer id) {
        CreditCard card = mgr.listById(id);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @PostMapping(value = "/bank/credit-card")
    public ResponseEntity<CreditCard> create(@Valid CreditCard item) {
        CreditCard card = mgr.create(item);
        return new ResponseEntity<>(card, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/bank/credit-card", params = "id")
    public ResponseEntity<CreditCard> delete(@RequestParam Integer id) {
        mgr.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/bank/credit-card", params = "id")
    public ResponseEntity<CreditCard> update(@Valid CreditCard item, @RequestParam Integer id) {
        CreditCard card = mgr.update(item, id);
        return new ResponseEntity<>(card, HttpStatus.ACCEPTED);
    }
}
