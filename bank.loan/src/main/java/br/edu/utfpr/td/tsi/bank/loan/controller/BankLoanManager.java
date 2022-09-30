package br.edu.utfpr.td.tsi.bank.loan.controller;

import br.edu.utfpr.td.tsi.bank.client.controller.ClientManager;
import br.edu.utfpr.td.tsi.bank.client.model.Client;
import br.edu.utfpr.td.tsi.bank.loan.dao.BankLoanDAO;
import br.edu.utfpr.td.tsi.bank.loan.exception.BankLoanIllegalArgumentsException;
import br.edu.utfpr.td.tsi.bank.loan.exception.BankLoanNotEnoughSalaryException;
import br.edu.utfpr.td.tsi.bank.loan.exception.BankLoanNotFoundException;
import br.edu.utfpr.td.tsi.bank.loan.model.BankLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankLoanManager implements BankLoanController {

    @Autowired
    private BankLoanDAO dao;
    @Autowired
    private ClientManager clientManager;

    @Override
    public BankLoan create(BankLoan item) {
        Client client = clientManager.searchById(item.getClient());
        if(client.getSalary() < 28800D){
            if(item != null)return dao.save(item);
            else throw new BankLoanIllegalArgumentsException();
        }else{
            throw new BankLoanNotEnoughSalaryException();
        }
    }

    @Override
    public BankLoan update(BankLoan item, Integer id) {
        item.setId(id);
        dao.findById(id).orElseThrow(BankLoanNotFoundException::new);
        return dao.save(item);
    }

    @Override
    public void delete(Integer id) {
        dao.findById(id).orElseThrow(BankLoanNotFoundException::new);
        dao.deleteById(id);
    }

    @Override
    public List<BankLoan> listAll() {
        return dao.findAll();
    }

    @Override
    public BankLoan listById(Integer id) {
        return dao.findById(id).orElseThrow(BankLoanNotFoundException::new);
    }
}
