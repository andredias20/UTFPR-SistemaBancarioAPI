package br.edu.utfpr.td.tsi.bank.account.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "account_transactions")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String clientCPF;
    private String otherCPF;
    private Double value;
    private String msg;

    @Column(insertable = false, updatable = false)
    @UpdateTimestamp
    private Date lastTouched;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;

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
