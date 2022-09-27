package br.edu.utfpr.td.tsi.bank.account.controller;

import java.util.List;

import br.edu.utfpr.td.tsi.bank.account.dao.TransactionDAO;
import br.edu.utfpr.td.tsi.bank.account.model.*;
import br.edu.utfpr.td.tsi.bank.client.controller.ClientManager;
import br.edu.utfpr.td.tsi.bank.client.dao.ClientDAO;
import br.edu.utfpr.td.tsi.bank.client.model.Client;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionManager implements TransactionController{

    @Autowired
    private TransactionDAO dao;
    @Autowired
    private ClientDAO cliDao;

    @Override
    public void register(Transaction item) {
        Client remetente = cliDao.searchClientByCpfEquals(item.getClientCPF());
        //Aqui ocorreria uma validação de existencia ou nao da conta de destino

        if(remetente != null){
            dao.save(item);
        }
    }

    @Override
    public Transaction listById(Integer id) {
        Transaction transaction= null;
        try{
            transaction = dao.findById(id).get();
        }catch (Exception e){
            e.printStackTrace();
        }


        return transaction;
    }

    @Override
    public List<Transaction> listAll() {
        return dao.searchAll();
    }
}
