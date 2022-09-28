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
    public void create(Client item) {
        try {
            if (item.getSalary() > 1200D) {
                dao.save(item);
            } else {
                throw new ClientExceptionRevenue("Client doesn't have enough revenue");
            }
        }catch(ClientExceptionRevenue e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Client item) {
        try {
            if (item.getId() != null) {
                dao.save(item);
            } else {
                throw new ClientException("The client ID was not informed");
            }
        }catch (ClientException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            if (id != null) {
                dao.deleteById(id);
            } else {
                throw new ClientException("The client ID was not informed");
            }
        }catch(ClientException e){
            e.printStackTrace();
        }
    }

    @Override
    public Client searchById(Integer id) {
        Client client = null;
        try {
            if (id != null) {
                client = dao.findById(id).get();
            } else {
                throw new ClientExceptionNotFound("Client not found");
            }
        } catch (ClientExceptionNotFound e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public Client searchByCPF(String cpf) {
        Client client = null;
        try {
            if (cpf != null) {
                client = dao.searchClientByCpfEquals(cpf);
                if (client == null) throw new ClientExceptionNotFound("Client not found");
            } else {

                throw new ClientExceptionNotFound("Client not informed");

            }
        } catch (ClientExceptionNotFound e) {
            throw new RuntimeException(e);
        }
        return client;
    }

    @Override
    public List<Client> searchByName(String name) {
        List<Client> client = null;
        try {
            if (name != null) {
                client = dao.searchClientsByName(name);
                if (client == null) throw new ClientExceptionNotFound("Client not found");
            } else {
                throw new ClientExceptionNotFound("Client not informed");
            }
        }catch (ClientExceptionNotFound e){
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public List<Client> searchAll() {
        return dao.searchAll();
    }
}
