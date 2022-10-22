package br.edu.utfpr.td.tsi.bank.modules.credit.card.controller;

import br.edu.utfpr.td.tsi.bank.modules.credit.card.model.CreditCard;

import java.util.List;

public interface CreditCardController {
    List<CreditCard> listAll();
    CreditCard listById(Integer id);
    CreditCard create(CreditCard item);
    void delete(Integer id);
    CreditCard update(CreditCard item, Integer id);

}
