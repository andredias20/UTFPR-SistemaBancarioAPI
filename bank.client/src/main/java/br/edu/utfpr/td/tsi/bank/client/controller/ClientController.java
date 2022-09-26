package br.edu.utfpr.td.tsi.bank.client.controller;

import br.edu.utfpr.td.tsi.bank.client.exceptions.ClientException;
import br.edu.utfpr.td.tsi.bank.client.exceptions.ClientExceptionNotFound;
import br.edu.utfpr.td.tsi.bank.client.exceptions.ClientExceptionRevenue;
import br.edu.utfpr.td.tsi.bank.client.model.Client;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface ClientController {

    void create(Client item) throws ClientExceptionRevenue;
    void update(Client item) throws ClientException;
    void delete(Integer id) throws ClientException;
    Client searchById(Integer id) throws ClientExceptionNotFound;
    Client searchByCPF(String cpf) throws ClientExceptionNotFound;
    List<Client> searchByName(String name) throws ClientExceptionNotFound;
    List<Client> searchAll();

}
