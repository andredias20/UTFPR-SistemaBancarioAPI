package br.edu.utfpr.td.tsi.bank.client;

import br.edu.utfpr.td.tsi.bank.client.controller.ClientController;
import br.edu.utfpr.td.tsi.bank.client.exceptions.ClientException;
import br.edu.utfpr.td.tsi.bank.client.exceptions.ClientExceptionNotFound;
import br.edu.utfpr.td.tsi.bank.client.exceptions.ClientExceptionRevenue;
import br.edu.utfpr.td.tsi.bank.client.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientResources {

    @Autowired
    private ClientController mgr;

    @PostMapping(path = "/client", consumes = "application/json", produces = "application/json")
    public Client create(@RequestBody Client item) throws ClientExceptionRevenue {
            mgr.create(item);
            return item;
    }

    @PutMapping(path = "/client{id}", consumes = "application/json", produces = "application/json")
    public Client update(Integer id, Client item) throws ClientException{
        item.setId(id);
        mgr.update(item);
        return item;
    }

    @DeleteMapping(path = "/client{id}")
    public void delete(@RequestParam Integer id) throws ClientException{
        mgr.delete(id);
    }


    @GetMapping(path = "/client{id}", produces = "application/json")
    public Client searchById(@RequestParam Integer id) throws ClientExceptionNotFound {
        return mgr.searchById(id);
    }

    public Client searchByCPF(String cpf) {
        return null;
    }

    public List<Client> searchByName(String name) {
        return null;
    }

    @GetMapping(path = "/client")
    public List<Client> searchAll() {
        return mgr.searchAll();
    }

}
