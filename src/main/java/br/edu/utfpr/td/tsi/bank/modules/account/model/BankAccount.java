package br.edu.utfpr.td.tsi.bank.modules.account.model;



import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldId;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldNamespace;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldProperty;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;

import java.io.Serializable;
import javax.persistence.*;

@JsonldResource
@JsonldNamespace(name = "s", uri = "http://schema.org/")
@JsonldType("s:Text")

@Entity
@Table(name = "bank_account")
public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonldId
    Integer id;

    boolean active;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    Client client;

    Integer agency;
    @JsonldProperty("s:accountId")
    Long accountNumber;

    @JsonldProperty("s:")//FAULT
    @Basic(fetch = FetchType.LAZY, optional = false)
    Integer password;

    public BankAccount() { }

    public BankAccount(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgency() {
        return agency;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAgency(Integer agency) {
        this.agency = agency;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer key) {
        this.password = key;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", active=" + active +
                ", client=" + client +
                ", agency=" + agency +
                ", accountNumber=" + accountNumber +
                ", password=" + password +
                '}';
    }
}
