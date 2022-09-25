package br.edu.utfpr.td.tsi.bank.client.dao;

import br.edu.utfpr.td.tsi.bank.client.model.*;
import org.springframework.data.repository.CrudRepository;

public interface ClientDAO extends CrudRepository<Client, Integer> {
}