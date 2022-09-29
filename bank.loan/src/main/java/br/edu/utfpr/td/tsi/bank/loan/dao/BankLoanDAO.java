package br.edu.utfpr.td.tsi.bank.loan.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.td.tsi.bank.loan.model.BankLoan;

import java.util.List;

public interface BankLoanDAO extends CrudRepository<BankLoan, Integer> {

    @Query(value = "SELECT a FROM BankLoan a")
    List<BankLoan> findAll();

}