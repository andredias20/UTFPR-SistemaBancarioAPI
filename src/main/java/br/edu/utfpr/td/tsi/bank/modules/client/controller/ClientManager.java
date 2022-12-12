package br.edu.utfpr.td.tsi.bank.modules.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.bank.modules.client.dao.ClientDAO;
import br.edu.utfpr.td.tsi.bank.modules.client.exception.ClientCPFCannotBeCreated;
import br.edu.utfpr.td.tsi.bank.modules.client.exception.ClientNotFoundException;
import br.edu.utfpr.td.tsi.bank.modules.client.exception.ClientSalaryNotApplicable;
import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;

@Service
public class ClientManager implements ClientController {

	@Autowired
    private ClientDAO dao;

    @Override
    public Client create(Client item) {
        System.out.println();
        if (dao.findByCpf(item.getCpf()).isPresent()) //If the search finds a Client with the same CPF, it doesnt allow to create another
            throw new ClientCPFCannotBeCreated();


        if (item.getSalary() > 1200D) {
            dao.save(item);
        } else throw new ClientSalaryNotApplicable();
        return item;
    }

    @Override
    public void update(Client item) {
        dao.findByCpf(item.getCpf())
                .orElseThrow(ClientNotFoundException::new);
        dao.save(item);
    }

    @Override
    public void delete(String id){
        dao.findByCpf(id)
                .orElseThrow(ClientNotFoundException::new);
        dao.deleteById(id);
    }

    @Override
    public Client searchByCPF(String cpf) {
        return dao.findByCpf(cpf)
                .orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public List<Client> searchByEmail(String email){
        return dao.searchClientsByEmail(email)
                .orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public Client findById(int id) throws RuntimeException {
        return dao.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public List<Client> searchAll() {
        return dao.searchAll();
    }

}
