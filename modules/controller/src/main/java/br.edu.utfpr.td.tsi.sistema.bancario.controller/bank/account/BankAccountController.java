package br.edu.utfpr.td.tsi.sistema.bancario.controller.bank.account;

import br.edu.utfpr.td.tsi.sistema.bancario.domain.bank.account.BankAccount;

import java.util.List;

public interface BankAccountController {

    void openAccount();
    void transfer();

    Double balance(Integer clientID);

    BankAccount listById(Integer id);
    List<BankAccount> listAll();


}
