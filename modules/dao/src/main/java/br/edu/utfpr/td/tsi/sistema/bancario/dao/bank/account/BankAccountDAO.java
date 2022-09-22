package br.edu.utfpr.td.tsi.sistema.bancario.dao.bank.account;


import br.edu.utfpr.td.tsi.sistema.bancario.domain.bank.account.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountDAO extends CrudRepository<BankAccount, Integer> {}
