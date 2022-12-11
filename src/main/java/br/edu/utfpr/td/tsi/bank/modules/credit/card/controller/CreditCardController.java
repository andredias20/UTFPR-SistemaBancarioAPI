package br.edu.utfpr.td.tsi.bank.modules.credit.card.controller;

import java.util.List;

import br.edu.utfpr.td.tsi.bank.modules.credit.card.model.CreditCard;

public interface CreditCardController {
    List<CreditCard> listAll() throws RuntimeException;
    CreditCard listById(Integer id) throws RuntimeException;
    CreditCard listByClient(String cpf) throws RuntimeException;
    CreditCard create(CreditCard item) throws RuntimeException;
    void delete(Integer id);
    CreditCard update(CreditCard item, Integer id) throws RuntimeException;

}
