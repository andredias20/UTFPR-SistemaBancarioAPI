package br.edu.utfpr.td.tsi.bank.credit.card.controller;

import br.edu.utfpr.td.tsi.bank.credit.card.dao.CreditCardDAO;
import br.edu.utfpr.td.tsi.bank.credit.card.model.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CreditCardManager implements CreditCardController{

    private CreditCardDAO dao;

    @Override
    public List<CreditCard> listAll() {
        return dao.getAll();
    }

    @Override
    public CreditCard listById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public void create(CreditCard item) {
        dao.save(item);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public CreditCard update(CreditCard item) {
        dao.save(item);
        return item;
    }
}
