package br.edu.utfpr.td.tsi.bank.account.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Transaction implements Serializable {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Pattern(regexp = "\n{3}.\n{3}.\n{3}-\n{2}", message = "Value don't correspond to default value ###.###.###-##, where # is digits 0-9.")
    private String clientCPF;
    @Pattern(regexp = "\n{3}.\n{3}.\n{3}-\n{2}", message = "Value don't correspond to default value ###.###.###-##, where # is digits 0-9.")
    private String otherCPF;
    @NotBlank
    private Long destAccountNumber;
    @NotBlank
    private Short destAgencyNumber;
    @NotBlank
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

    public Long getDestAccountNumber() {
        return destAccountNumber;
    }

    public void setDestAccountNumber(Long destAccountNumber) {
        this.destAccountNumber = destAccountNumber;
    }

    public Short getDestAgencyNumber() {
        return destAgencyNumber;
    }

    public void setDestAgencyNumber(Short destAgencyNumber) {
        this.destAgencyNumber = destAgencyNumber;
    }

    public Date getLastTouched() {
        return lastTouched;
    }

    public void setLastTouched(Date lastTouched) {
        this.lastTouched = lastTouched;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
