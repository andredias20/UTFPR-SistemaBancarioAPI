package br.edu.utfpr.td.tsi.sistema.bancario.dao.credit.card;

import br.edu.utfpr.td.tsi.sistema.bancario.domain.credit.card.CreditCard;
import org.springframework.data.repository.CrudRepository;

public interface CreditCardDAO extends CrudRepository<CreditCard, Integer> {
}