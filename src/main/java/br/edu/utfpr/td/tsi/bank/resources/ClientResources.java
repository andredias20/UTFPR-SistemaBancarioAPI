package br.edu.utfpr.td.tsi.bank.resources;

import br.edu.utfpr.td.tsi.bank.modules.client.controller.ClientController;
import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ioinformarics.oss.jackson.module.jsonld.JsonldModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
public class ClientResources {

    @Autowired
    private ClientController mgr;

    private ObjectMapper mapper = new ObjectMapper();

    @PostConstruct
    private void initialize(){
        mapper.registerModule(new JsonldModule());
    }


    @PostMapping(path = "/client", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> create(@Validated @RequestBody Client item) throws JsonProcessingException {
            mgr.create(item);
            return new ResponseEntity<>(mapper.writeValueAsString(item), HttpStatus.CREATED);
    }

    @PutMapping(path = "/client", consumes = "application/json", produces = "application/json", params = "id")
    public ResponseEntity<String> update(@RequestParam Integer id, @Validated @RequestBody Client item) throws JsonProcessingException {
        item.setId(id);
        mgr.update(item);
        return new ResponseEntity<>(mapper.writeValueAsString(item), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/client", params = "id")
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        mgr.delete(id);
        return new ResponseEntity<>("Cliente: "+id+" Deleted", HttpStatus.ACCEPTED);
    }


    @GetMapping(path = "/client", params = "id", produces = "application/json")
    public ResponseEntity<String> searchById(@RequestParam(name = "id") Integer id) throws JsonProcessingException {
        Client client = mgr.searchById(id);
        return new ResponseEntity<>(mapper.writeValueAsString(client), HttpStatus.OK);
    }

    @GetMapping(path = "/client", params = "cpf", produces = "application/json")
    public ResponseEntity<String> searchByCPF(@RequestParam("cpf") String cpf) throws JsonProcessingException {
        Client client = mgr.searchByCPF(cpf);
        return new ResponseEntity<>(mapper.writeValueAsString(client), HttpStatus.OK);
    }

    @GetMapping(path = "/client", params = "name", produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> searchByName(@RequestParam(name = "name") String name) throws JsonProcessingException, RuntimeException {
        return new ResponseEntity<>(
            mapper.writeValueAsString(
                mgr.searchByName(name)
                ), HttpStatus.OK);
    }

    @GetMapping(path = "/client", produces = "application/json")
    @ResponseBody
    public String searchAll() throws JsonProcessingException {
        return mapper.writeValueAsString(
            mgr.searchAll()
            );
    }

}
