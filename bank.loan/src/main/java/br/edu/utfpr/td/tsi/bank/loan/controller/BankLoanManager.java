package br.edu.utfpr.td.tsi.bank.loan.controller;

import br.edu.utfpr.td.tsi.bank.loan.dao.BankLoanDAO;
import br.edu.utfpr.td.tsi.bank.loan.exception.BankLoanIllegalArgumentsException;
import br.edu.utfpr.td.tsi.bank.loan.model.BankLoan;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BankLoanManager implements BankLoanController {

    @Autowired
    BankLoanDAO dao;

    @Override
    public BankLoan create(BankLoan item) {
        if(item != null)return dao.save(item);
        else throw new BankLoanIllegalArgumentsException();
    }

    @Override
    public BankLoan update(BankLoan item, Integer id) {
        item.setId(id);
        dao.findById(id).orElseThrow();
        return dao.save(item);
    }

    @Override
    public void delete(Integer id) {
        dao.findById(id).orElseThrow();
        dao.deleteById(id);
    }

    @Override
    public List<BankLoan> listAll() {
        return dao.findAll();
    }

    @Override
    public BankLoan listById(Integer id) {
        return dao.findById(id).orElseThrow();
    }
}
