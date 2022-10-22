package br.edu.utfpr.td.tsi.bank.resources;

import br.edu.utfpr.td.tsi.bank.modules.client.controller.ClientController;
import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientResources {
    @Autowired
    private ClientController mgr;

    @PostMapping(path = "/client", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Client> create(@Validated @RequestBody Client item) {
            mgr.create(item);
            return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping(path = "/client", consumes = "application/json", produces = "application/json", params = "id")
    public ResponseEntity<Client> update(@RequestParam Integer id, @Validated @RequestBody Client item) {
        item.setId(id);
        mgr.update(item);
        return new ResponseEntity<>(item, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/client", params = "id")
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        mgr.delete(id);
        return new ResponseEntity<>("Cliente: "+id+" Deleted", HttpStatus.ACCEPTED);
    }


    @GetMapping(path = "/client", params = "id")
    public ResponseEntity<Client> searchById(@RequestParam(name = "id") Integer id) {
        Client client = mgr.searchById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping(path = "/client", params = "cpf")
    public ResponseEntity<Client> searchByCPF(@RequestParam("cpf") String cpf) {
        Client client = mgr.searchByCPF(cpf);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping(path = "/client", params = "name")
    @ResponseBody
    public ResponseEntity<List<Client>> searchByName(@RequestParam(name = "name") String name) {

        return new ResponseEntity<>(mgr.searchByName(name), HttpStatus.OK);
    }

    @GetMapping(path = "/client")
    @ResponseBody
    public List<Client> searchAll() {
        return mgr.searchAll();
    }

}
