package br.edu.utfpr.td.tsi.bank.modules.credit.card.dao;


import br.edu.utfpr.td.tsi.bank.modules.credit.card.model.CreditCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardDAO extends CrudRepository<CreditCard, Integer> {

    @Query(value = "SELECT a FROM CreditCard a")
    List<CreditCard> getAll();



}