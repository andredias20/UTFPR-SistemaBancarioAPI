package br.edu.utfpr.td.tsi.bank.account.dao;
	
import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.td.tsi.bank.account.model.BankAccount;

public interface BankAccountDAO extends CrudRepository<BankAccount, Integer> {}
	