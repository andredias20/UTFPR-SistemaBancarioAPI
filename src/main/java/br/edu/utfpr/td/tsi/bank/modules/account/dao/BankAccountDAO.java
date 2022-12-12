package br.edu.utfpr.td.tsi.bank.modules.account.dao;
	
import br.edu.utfpr.td.tsi.bank.modules.account.model.BankAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankAccountDAO extends CrudRepository<BankAccount, Integer> {

    @Query(value = "SELECT a FROM BankAccount a WHERE a.accountNumber = ?2 AND a.agency = ?1")
   Optional<BankAccount> existsByAccountNumber(Integer agency, Long account);

    @Query(value = "SELECT a FROM BankAccount a")
    List<BankAccount> searchAll();
}
	