package br.edu.utfpr.td.tsi.bank.credit.card.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.utfpr.td.tsi.bank.credit.card.model.CreditCard;

import java.util.List;

@Repository
public interface CreditCardDAO extends CrudRepository<CreditCard, Integer> {

    @Query(value = "SELECT a FROM CreditCard a")
    List<CreditCard> getAll();



}