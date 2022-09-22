package br.edu.utfpr.td.tsi.sistema.bancario.domain.bank.account;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "account_transactions")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String clientCPF;

    private String otherCPF;

    private Double value;
    private String msg;

    public Transaction() {
    }

    public Transaction(Integer id, String clientCPF, String otherCPF, Double value, String msg) {
        this.id = id;
        this.clientCPF = clientCPF;
        this.otherCPF = otherCPF;
        this.value = value;
        this.msg = msg;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getClientCPF() {
        return clientCPF;
    }

    public void setClientCPF(String clientCPF) {
        this.clientCPF = clientCPF;
    }

    public String getOtherCPF() {
        return otherCPF;
    }

    public void setOtherCPF(String otherCPF) {
        this.otherCPF = otherCPF;
    }
}
