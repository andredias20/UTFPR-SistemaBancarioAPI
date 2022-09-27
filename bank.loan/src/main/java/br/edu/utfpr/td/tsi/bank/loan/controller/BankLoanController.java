package br.edu.utfpr.td.tsi.bank.loan.controller;

import br.edu.utfpr.td.tsi.bank.loan.model.BankLoan;

import java.util.List;

public interface BankLoanController {
    BankLoan simulateLoan(Double amount, Integer months);
    void createLoan(BankLoan item);
    List<BankLoan> listAll();
    BankLoan listById(Integer id);


}
