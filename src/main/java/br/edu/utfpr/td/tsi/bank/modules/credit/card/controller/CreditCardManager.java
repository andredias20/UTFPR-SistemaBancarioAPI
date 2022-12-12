package br.edu.utfpr.td.tsi.bank.modules.credit.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.utfpr.td.tsi.bank.modules.client.controller.ClientManager;
import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;
import br.edu.utfpr.td.tsi.bank.modules.credit.card.dao.CreditCardDAO;
import br.edu.utfpr.td.tsi.bank.modules.credit.card.exception.CreditCardCreationNotAllowed;
import br.edu.utfpr.td.tsi.bank.modules.credit.card.exception.CreditCardNotFoundException;
import br.edu.utfpr.td.tsi.bank.modules.credit.card.model.CreditCard;

@Controller
public class CreditCardManager implements CreditCardController {

    @Autowired private CreditCardDAO dao;
    
    @Autowired private ClientManager cliMgr;

    @Override
    public List<CreditCard> listAll() {
        return dao.getAll();
    }

    @Override
    public CreditCard listById(Integer id) {
        return dao.findById(id)
        		.orElseThrow(CreditCardNotFoundException::new);
    }

    @Override
    public CreditCard create(CreditCard item) {
        String cpf = item.getClient_id().getCpf();
        var cli = cliMgr.searchByCPF(cpf);
        if(dao.existByClientId(cli).isPresent())
        	throw new CreditCardCreationNotAllowed();
        item = dao.save(item);
        updateClient(item.getId(),cli);
    	return item;
    }

    private void updateClient(int creditCardId, Client item){

    }


    @Override
    public void delete(Integer id) {
        dao.findById(id)
        	.orElseThrow(CreditCardNotFoundException::new);
        dao.deleteById(id);
    }

    @Override
    public CreditCard update(CreditCard item, Integer id) {
        item.setId(id);
        dao.findById(id)
        	.orElseThrow(CreditCardNotFoundException::new);
        return dao.save(item);
    }

	@Override
	public CreditCard listByClient(String cpf){
		return dao.findByClientId(new Client(cpf))
                .orElseThrow(CreditCardNotFoundException::new);
	}
}
