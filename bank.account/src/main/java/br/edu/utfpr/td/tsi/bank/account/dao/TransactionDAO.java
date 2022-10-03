package br.edu.utfpr.td.tsi.bank.account.dao;
	
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.utfpr.td.tsi.bank.account.model.Transaction;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionDAO extends CrudRepository<Transaction, Integer> {

    @Query(value = "SELECT t FROM Transaction t")
    List<Transaction> searchAll();

    @Query(value = "SELECT sum(t.amountValue) FROM Transaction t WHERE t.client = ?1")
    Double clientBalance(Integer id);

    @Query(value = "SELECT t FROM Transaction t WHERE t.client = ?1")
    List<Transaction> listTransactionsByClientId(Integer id);

    @Query(value = "SELECT t FROM Transaction t WHERE t.client = ?1 AND t.createdAt BETWEEN ?2 AND ?3")
    List<Transaction> listTransactionsByDate(Integer cliente_id, Date start, Date end);

}