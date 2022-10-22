package br.edu.utfpr.td.tsi.bank.modules.account.model;

import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    @Pattern(regexp = "\n{3}.\n{3}.\n{3}-\n{2}", message = "Value don't correspond to default value ###.###.###-##, where # is digits 0-9.")
    private String otherCPF;
    @NotBlank
    private Long destAccountNumber;
    @NotBlank
    private Short destAgencyNumber;
    @NotBlank
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
