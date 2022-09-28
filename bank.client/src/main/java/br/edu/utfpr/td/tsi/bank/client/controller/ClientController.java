package br.edu.utfpr.td.tsi.bank.client.controller;

import br.edu.utfpr.td.tsi.bank.client.exceptions.ClientException;
import br.edu.utfpr.td.tsi.bank.client.exceptions.ClientExceptionNotFound;
import br.edu.utfpr.td.tsi.bank.client.exceptions.ClientExceptionRevenue;
import br.edu.utfpr.td.tsi.bank.client.model.Client;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface ClientController {

    void create(Client item);
    void update(Client item);
    void delete(Integer id);
    Client searchById(Integer id);
    Client searchByCPF(String cpf);
    List<Client> searchByName(String name);
    List<Client> searchAll();

}
