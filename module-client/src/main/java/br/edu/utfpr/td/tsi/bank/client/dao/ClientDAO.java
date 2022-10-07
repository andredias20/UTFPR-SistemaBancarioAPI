package br.edu.utfpr.td.tsi.bank.client.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.utfpr.td.tsi.bank.client.model.Client;

@Repository
public interface ClientDAO extends CrudRepository<Client, Integer> {

    @Query(value = "SELECT c FROM Client c WHERE c.cpf = ?1")
    Client searchClientByCpfEquals(@Param("cpf") String cpf);

    @Query(value = "SELECT c FROM Client c WHERE c.name = ?1")
    List<Client> searchClientsByName(@Param("name") String name);

    @Query(value = "SELECT c FROM Client c")
    List<Client> searchAll();
}