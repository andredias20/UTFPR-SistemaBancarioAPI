package br.edu.utfpr.td.tsi.bank.account.dao;
	
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.td.tsi.bank.account.model.BankAccount;

import java.util.List;

public interface BankAccountDAO extends CrudRepository<BankAccount, Integer> {

    @Query(value = "SELECT a FROM BankAccount a WHERE a.accountNumber = ?2 AND a.agency = ?1")
    BankAccount existsByAccountNumber(Integer agency, Long account);

    @Query(value = "SELECT a FROM BankAccount a")
    List<BankAccount> searchAll();
}
	