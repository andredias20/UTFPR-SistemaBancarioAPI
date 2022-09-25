package br.edu.utfpr.td.tsi.bank.credit.card.dao;


import org.springframework.data.repository.CrudRepository;
import br.edu.utfpr.td.tsi.bank.credit.card.model.CreditCard;

public interface CreditCardDAO extends CrudRepository<CreditCard, Integer> {
}