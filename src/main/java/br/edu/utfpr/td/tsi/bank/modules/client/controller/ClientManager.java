package br.edu.utfpr.td.tsi.bank.modules.client.controller;

import java.util.List;

import br.edu.utfpr.td.tsi.bank.modules.client.exception.ClientCPFCannotBeCreated;
import br.edu.utfpr.td.tsi.bank.modules.client.exception.ClientCantBeNull;
import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.utfpr.td.tsi.bank.modules.client.dao.ClientDAO;
import br.edu.utfpr.td.tsi.bank.client.exception.ClientNotFoundException;
import br.edu.utfpr.td.tsi.bank.client.exception.ClientSalaryNotApplicable;

@Controller
public class ClientManager implements ClientController {

	@Autowired
    private ClientDAO dao;

    @Override
    public Client create(Client item) throws ClientCPFCannotBeCreated {
        if (dao.searchClientByCpfEquals(item.getCpf()) != null) throw new ClientCPFCannotBeCreated();
        if (item.getSalary() > 1200D) {
            item.setId(dao.save(item).getId());
        } else throw new ClientSalaryNotApplicable();
        return item;
    }

    @Override
    public void update(Client item) {
        dao.findById(item.getId()).orElseThrow(ClientNotFoundException::new);
        dao.save(item);
    }

    @Override
    public void delete(Integer id) throws ClientNotFoundException {
        dao.findById(id).orElseThrow(ClientNotFoundException::new);
        dao.deleteById(id);
    }

    @Override
    public Client searchById(Integer id) throws RuntimeException {
        if(id == null) throw new ClientCantBeNull();
        return dao.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public Client searchByCPF(String cpf) throws ClientNotFoundException{
        Client client = dao.searchClientByCpfEquals(cpf);
        if (client == null) throw new ClientNotFoundException();
        return client;
    }

    @Override
    public List<Client> searchByName(String name) throws ClientNotFoundException{
        List<Client> client = dao.searchClientsByName(name);
        if (client == null) throw new ClientNotFoundException();
        return client;
    }

    @Override
    public List<Client> searchAll() {
        return dao.searchAll();
    }
}