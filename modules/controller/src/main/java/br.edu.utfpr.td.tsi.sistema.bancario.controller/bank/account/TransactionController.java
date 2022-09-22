package br.edu.utfpr.td.tsi.sistema.bancario.controller.bank.account;

import br.edu.utfpr.td.tsi.sistema.bancario.domain.bank.account.Transaction;
import java.util.List;

public interface TransactionController {

    void register(Transaction item);
    Transaction listById(Integer id);
    List<Transaction> listAll();


}
