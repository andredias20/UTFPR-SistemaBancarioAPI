package br.edu.utfpr.td.tsi.bank.client.controller;

import br.edu.utfpr.td.tsi.bank.client.exception.ClientNotFoundException;
import br.edu.utfpr.td.tsi.bank.client.model.Client;
import br.edu.utfpr.td.tsi.bank.client.exception.ClientCPFCannotBeCreated;

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
