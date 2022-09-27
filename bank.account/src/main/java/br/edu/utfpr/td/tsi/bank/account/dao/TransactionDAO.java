package br.edu.utfpr.td.tsi.bank.account.dao;
	
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.td.tsi.bank.account.model.Transaction;

import java.util.List;

public interface TransactionDAO extends CrudRepository<Transaction, Integer> {

    @Query(value = "SELECT t FROM Transaction t")
    List<Transaction> searchAll();

}