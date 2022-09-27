package br.edu.utfpr.td.tsi.bank.account.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccount implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer client_id;
    private Short agency;
    private Long accountNumber;
    private Integer key;


    public BankAccount() { }

    public BankAccount(Integer id, Integer clientId, Short agency, Long accountNumber, Integer key) {
        this.id = id;
        this.client_id = clientId;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.key = key;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer clientId) {
        this.client_id = clientId;
    }

    public Short getAgency() {
        return agency;
    }

    public void setAgency(Short agency) {
        this.agency = agency;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }


}
