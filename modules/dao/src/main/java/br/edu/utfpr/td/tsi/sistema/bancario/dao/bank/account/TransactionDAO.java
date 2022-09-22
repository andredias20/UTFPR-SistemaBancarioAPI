package br.edu.utfpr.td.tsi.sistema.bancario.dao.bank.account;

import br.edu.utfpr.td.tsi.sistema.bancario.domain.bank.account.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionDAO extends CrudRepository<Transaction, Integer> {
}