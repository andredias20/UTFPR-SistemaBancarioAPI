package br.edu.utfpr.td.tsi.bank.loan.controller;

import br.edu.utfpr.td.tsi.bank.loan.model.BankLoan;

import java.util.List;

public interface BankLoanController {
    BankLoan create(BankLoan item);
    BankLoan update(BankLoan item, Integer id);
    void delete(Integer id);
    List<BankLoan> listAll();
    BankLoan listById(Integer id);
}
