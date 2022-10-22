package br.edu.utfpr.td.tsi.bank.modules.loan.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.utfpr.td.tsi.bank.modules.loan.model.BankLoan;

import java.util.List;

@Repository
public interface BankLoanDAO extends CrudRepository<BankLoan, Integer> {

    @Query(value = "SELECT a FROM BankLoan a")
    List<BankLoan> findAll();

}