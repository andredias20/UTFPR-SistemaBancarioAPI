package br.edu.utfpr.td.tsi.sistema.bancario.dao.client;

import br.edu.utfpr.td.tsi.sistema.bancario.domain.client.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientDAO extends CrudRepository<Client, Integer> {
}