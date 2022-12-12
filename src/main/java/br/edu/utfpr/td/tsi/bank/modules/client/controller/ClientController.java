package br.edu.utfpr.td.tsi.bank.modules.client.controller;

import java.util.List;

import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;

public interface ClientController {

    Client create(Client item) throws RuntimeException;
    void update(Client item) throws RuntimeException;
    void delete(String cpf) throws RuntimeException;
    Client searchByCPF(String cpf) throws RuntimeException;
    Client findById(int id)throws RuntimeException;
    List<Client> searchByEmail(String email) throws RuntimeException;
    List<Client> searchAll();

}
