package br.edu.utfpr.td.tsi.bank.modules.account.dao;
	
import br.edu.utfpr.td.tsi.bank.modules.account.model.BankAccount;
import br.edu.utfpr.td.tsi.bank.modules.account.model.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionDAO extends CrudRepository<Transaction, Integer> {

    @Query(value = "SELECT sum(t.amountValue) FROM Transaction t WHERE t.account  = ?1")
    Double clientBalance(BankAccount id);

    @Query(value = "SELECT t FROM Transaction t WHERE t.account = ?1")
    List<Transaction> listTransactionsByAccountId(BankAccount id);

    @Query(value = "SELECT t FROM Transaction t WHERE t.account = ?1 AND t.createdAt BETWEEN ?2 AND ?3")
    List<Transaction> listTransactionsByDate(BankAccount id, Date start, Date end);

}