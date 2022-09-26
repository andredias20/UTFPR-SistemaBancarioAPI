package br.edu.utfpr.td.tsi.bank.client.controller;

import br.edu.utfpr.td.tsi.bank.client.dao.ClientDAO;
import br.edu.utfpr.td.tsi.bank.client.exceptions.ClientException;
import br.edu.utfpr.td.tsi.bank.client.exceptions.ClientExceptionNotFound;
import br.edu.utfpr.td.tsi.bank.client.exceptions.ClientExceptionRevenue;
import br.edu.utfpr.td.tsi.bank.client.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientManager implements ClientController {

    @Autowired
    private ClientDAO dao;

    @Override
    public void create(Client item) throws ClientExceptionRevenue {
        if(item.getSalary() > 1200D){
            dao.save(item);
        }else{
            throw new ClientExceptionRevenue("Client doesn't have enough revenue");
        }
    }

    @Override
    public void update(Client item) throws ClientException {
        if(item.getId() != null){
            dao.save(item);
        }else{
            throw new ClientException("The client ID was not informed");
        }
    }

    @Override
    public void delete(Integer id) throws ClientException {
        if(id != null){
            dao.deleteById(id);
        }else{
            throw new ClientException("The client ID was not informed");
        }
    }

    @Override
    public Client searchById(Integer id) throws ClientExceptionNotFound {
        Client client = null;

        if (id != null){
            client = dao.findById(id).get();
        }else {
            throw new ClientExceptionNotFound("Client not found");
        }
        return client;
    }

    @Override
    public Client searchByCPF(String cpf) throws ClientExceptionNotFound {
        Client client = null;

        if (cpf != null){
            client = dao.searchClientByCpfEquals(cpf);
            if (client == null) throw new ClientExceptionNotFound("Client not found");
        }else {
            throw new ClientExceptionNotFound("Client not informed");
        }
        return client;
    }

    @Override
    public List<Client> searchByName(String name) throws ClientExceptionNotFound {
        List<Client> client = null;

        if (name != null){
            client = dao.searchClientsByName(name);
            if (client == null) throw new ClientExceptionNotFound("Client not found");
        }else {
            throw new ClientExceptionNotFound("Client not informed");
        }
        return client;
    }

    @Override
    public List<Client> searchAll() {
        return dao.searchAll();
    }
}
