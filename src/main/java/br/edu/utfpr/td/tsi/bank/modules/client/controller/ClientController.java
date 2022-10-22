package br.edu.utfpr.td.tsi.bank.modules.client.controller;

import br.edu.utfpr.td.tsi.bank.client.exception.ClientNotFoundException;
import br.edu.utfpr.td.tsi.bank.modules.client.exception.ClientCPFCannotBeCreated;
import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;

import java.util.List;

public interface ClientController {

    Client create(Client item) throws ClientCPFCannotBeCreated;
    void update(Client item) throws ClientNotFoundException;
    void delete(Integer id) throws ClientNotFoundException;
    Client searchById(Integer id) throws ClientNotFoundException;
    Client searchByCPF(String cpf) throws ClientNotFoundException;
    List<Client> searchByName(String name) throws ClientNotFoundException;
    List<Client> searchAll();

}
