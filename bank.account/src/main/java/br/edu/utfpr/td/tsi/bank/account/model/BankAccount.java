package br.edu.utfpr.td.tsi.bank.account.model;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.utfpr.td.tsi.bank.client.model.Client;

@Entity
@Table(name = "account")
public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne( targetEntity = Client.class)
    private Integer clientID;

    private Short agency;
    private Long accountNumber;
    private Integer key;


    public BankAccount() {
    }

    public BankAccount(Integer id, Integer clientID, Short agency, Long accountNumber, Integer key) {
        this.id = id;
        this.clientID = clientID;
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

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
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
