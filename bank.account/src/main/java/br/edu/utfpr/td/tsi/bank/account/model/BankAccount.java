package br.edu.utfpr.td.tsi.bank.account.model;

import br.edu.utfpr.td.tsi.bank.client.model.Client;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "bank_account")
public class BankAccount implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private boolean active;

    @NotBlank
    @OneToOne(targetEntity = Client.class)
    private Integer client;
    @NotBlank
    private Integer agency;
    @NotBlank
    private Long accountNumber;
    @NotBlank
    private Integer password;

    public BankAccount() { }

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

    public Integer getClient() {
        return client;
    }
    public void setClient(Integer client_id) {
        this.client = client_id;
    }
}
