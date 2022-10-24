package br.edu.utfpr.td.tsi.bank.modules.client.controller;

import java.util.List;

import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;

public interface ClientController {

    Client create(Client item) throws RuntimeException;
    void update(Client item) throws RuntimeException;
    void delete(Integer id) throws RuntimeException;
    Client searchById(Integer id) throws RuntimeException;
    Client searchByCPF(String cpf) throws RuntimeException;
    List<Client> searchByName(String name) throws RuntimeException;
    List<Client> searchAll();

}
