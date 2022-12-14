package br.edu.utfpr.td.tsi.bank.modules.client.dao;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDAO extends CrudRepository<Client, Integer> {

    @Query(value = "SELECT c FROM Client c WHERE c.cpf = ?1")
    Optional<Client> findByCpf(@Param("cpf") String cpf);

    @Query(value = "SELECT c FROM Client c WHERE c.email = ?1")
    Optional<List<Client>> searchClientsByEmail(@Param("email") String name);

    @Query(value = "SELECT c FROM Client c")
    List<Client> searchAll();

    @Modifying
    @Query(value = "DELETE FROM Client c WHERE c.cpf = ?1")
    void deleteById(@Param("cpf") String cpf);
}