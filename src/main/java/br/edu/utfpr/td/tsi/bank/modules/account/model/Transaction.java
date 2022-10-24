package br.edu.utfpr.td.tsi.bank.modules.account.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.br.CPF;

@Entity	
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "account_id is needed")
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private BankAccount account;
    @NotBlank(message = "Data from Destination account is needed (CPF is empty)")
    @CPF
    private String otherCPF;
    @NotNull(message = "Data from Destination account is needed (Account  Destination is empty)")
    private Long destAccountNumber;
    @NotNull(message = "Data from Destination account is needed (Account Agency is empty)")
    private Short destAgencyNumber;
    @NotNull(message = "Amount is mandatory")
    private Double amountValue;
    private String optionalMessage;

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

    public Double getAmountValue() {
        return amountValue;
    }

    public void setAmountValue(Double value) {
        this.amountValue = value;
    }

    public String getOptionalMessage() {
        return optionalMessage;
    }

    public void setOptionalMessage(String msg) {
        this.optionalMessage = msg;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
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
