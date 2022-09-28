package br.edu.utfpr.td.tsi.bank.loan.controller;

import br.edu.utfpr.td.tsi.bank.loan.model.BankLoan;

import java.util.List;

public interface BankLoanController {
    void create(BankLoan item);
    void update(BankLoan item);
    void delete(Integer id);
    List<BankLoan> listAll();
    BankLoan listById(Integer id);
}
