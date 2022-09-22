package br.edu.utfpr.td.tsi.sistema.bancario.dao.bank.loan;

import br.edu.utfpr.td.tsi.sistema.bancario.domain.bank.loan.BankLoan;
import org.springframework.data.repository.CrudRepository;

public interface BankLoanDAO extends CrudRepository<BankLoan, Integer> {
}