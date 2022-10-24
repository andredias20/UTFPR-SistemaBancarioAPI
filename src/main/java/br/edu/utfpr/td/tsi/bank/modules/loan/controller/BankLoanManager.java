package br.edu.utfpr.td.tsi.bank.modules.loan.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.utfpr.td.tsi.bank.modules.client.controller.ClientManager;
import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;
import br.edu.utfpr.td.tsi.bank.modules.loan.dao.BankLoanDAO;
import br.edu.utfpr.td.tsi.bank.modules.loan.exception.BankLoanIllegalArgumentsException;
import br.edu.utfpr.td.tsi.bank.modules.loan.exception.BankLoanNotEnoughSalaryException;
import br.edu.utfpr.td.tsi.bank.modules.loan.exception.BankLoanNotFoundException;
import br.edu.utfpr.td.tsi.bank.modules.loan.model.BankLoan;
import br.edu.utfpr.td.tsi.bank.modules.loan.controller.BankLoanController;

@Controller
public class BankLoanManager implements BankLoanController {

	@Autowired
    private BankLoanDAO dao;
	@Autowired
    private ClientManager clientManager;

	@Override
    public BankLoan create(BankLoan item) {
        if(item == null) throw new BankLoanIllegalArgumentsException();
        Client client = clientManager.searchById(item.getClient().getId());
        if(client.getSalary() >= 28008.00)
				return dao.save(item);
        else
            throw new BankLoanNotEnoughSalaryException();

    }

    @Override
    public BankLoan update(BankLoan item, Integer id) {
        item.setId(id);
        listById(id);
        return dao.save(item);
    }

    @Override
    public void delete(Integer id) {
        listById(id);
        dao.deleteById(id);
    }

    @Override
    public List<BankLoan> listAll() {
        return dao.findAll();
    }

    @Override
    public BankLoan listById(Integer id) {
        return dao.findById(id).orElseThrow(BankLoanNotFoundException::new);
    }

    @Override
    public List<BankLoan> listLoansByClientId(Integer client_id) {
        clientManager.searchById(client_id);
        return dao.findAllByClientId(new Client(client_id));
    }
}
