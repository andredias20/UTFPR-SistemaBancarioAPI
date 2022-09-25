package br.edu.utfpr.td.tsi.bank.loan.dao;

import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.td.tsi.bank.loan.model.BankLoan;

public interface BankLoanDAO extends CrudRepository<BankLoan, Integer> {
}