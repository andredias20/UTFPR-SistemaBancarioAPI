package br.edu.utfpr.td.tsi.bank.credit.card.controller;

import br.edu.utfpr.td.tsi.bank.credit.card.dao.CreditCardDAO;
import br.edu.utfpr.td.tsi.bank.credit.card.exception.CreditCardInvalidArgumentsException;
import br.edu.utfpr.td.tsi.bank.credit.card.exception.CreditCardNotFoundException;
import br.edu.utfpr.td.tsi.bank.credit.card.model.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CreditCardManager implements CreditCardController{

    @Autowired
    private CreditCardDAO dao;

    @Override
    public List<CreditCard> listAll() {
        return dao.getAll();
    }

    @Override
    public CreditCard listById(Integer id) {
        return dao.findById(id).orElseThrow(CreditCardNotFoundException::new);
    }

    @Override
    public CreditCard create(CreditCard item) {
        if(item != null) return dao.save(item);
        else throw new CreditCardInvalidArgumentsException();
    }

    @Override
    public void delete(Integer id) {
        dao.findById(id).orElseThrow(CreditCardNotFoundException::new);
        dao.deleteById(id);
    }

    @Override
    public CreditCard update(CreditCard item, Integer id) {
        item.setId(id);
        dao.findById(id).orElseThrow();
        return dao.save(item);
    }
}
