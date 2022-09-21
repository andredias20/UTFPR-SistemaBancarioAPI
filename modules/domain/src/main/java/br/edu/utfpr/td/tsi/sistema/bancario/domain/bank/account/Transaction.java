package br.edu.utfpr.td.tsi.sistema.bancario.domain.bank.account;

import br.edu.utfpr.td.tsi.sistema.bancario.domain.client.Client;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "account_transactions")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(targetEntity = Client.class)
    private Integer clientID;
    private String otherClientCPF;

    private Double value;
    private String msg;

    public Transaction() {
    }

    public Transaction(Integer id, Integer clientID, String otherClientCPF, Double value, String msg) {
        this.id = id;
        this.clientID = clientID;
        this.otherClientCPF = otherClientCPF;
        this.value = value;
        this.msg = msg;
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

    public String getOtherClientCPF() {
        return otherClientCPF;
    }

    public void setOtherClientCPF(String otherClientCPF) {
        this.otherClientCPF = otherClientCPF;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
