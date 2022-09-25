package br.edu.utfpr.td.tsi.bank.account.dao;
	
import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.td.tsi.bank.account.model.Transaction;

public interface TransactionDAO extends CrudRepository<Transaction, Integer> {
}