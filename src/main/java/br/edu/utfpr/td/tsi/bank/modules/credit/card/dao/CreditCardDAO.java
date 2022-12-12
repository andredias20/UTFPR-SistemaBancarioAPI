package br.edu.utfpr.td.tsi.bank.modules.credit.card.dao;


import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;
import br.edu.utfpr.td.tsi.bank.modules.credit.card.model.CreditCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreditCardDAO extends CrudRepository<CreditCard, Integer> {

    @Query(value = "SELECT a FROM CreditCard a")
    List<CreditCard> getAll();

	@Query(value = "SELECT a FROM CreditCard a WHERE a.client_id = ?1")
	Optional<CreditCard> findByClientId(Client client);
	
	@Query(value = "SELECT a FROM CreditCard a WHERE a.client_id = ?1")
	Optional<CreditCard> existByClientId(Client client);



}