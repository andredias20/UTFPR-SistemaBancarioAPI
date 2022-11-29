package br.edu.utfpr.td.tsi.bank.modules.credit.card.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldId;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldNamespace;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldProperty;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;

@JsonldResource
@JsonldNamespace(name = "s", uri = "http://www.semanticweb.org/andre/ontologies/2022/10/BankAccount")
@JsonldType("s:CreditCardAccount")
@Entity
@Table(name = "credit_card")
public class CreditCard implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonldId
    private Integer id;
    
    @JsonldProperty("s:clientID")
    @OneToOne
	@NotNull(message = "client_id is mandatory")
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client_id;
    
    @JsonldProperty("s:cardHolder")
	@NotNull(message = "Card Holder is mandatory")
    private String cardHolder;
	
    @JsonldProperty("s:cardNumber")
    @NotNull(message = "Card number is mandatory")
    private Long cardNumber;
	
    @JsonldProperty("s:validThrough")
	@NotNull(message = "ValidThru is mandatory")
	@DateTimeFormat(iso = ISO.DATE)
    private Date validThru;
    
    @JsonldProperty("s:securityCode")
	@NotNull(message = "Security code is mandatory")
    private Short securityCode;

    public CreditCard() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient_id() {
        return client_id;
    }

    public void setClient_id(Client client_id) {
        this.client_id = client_id;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getValidThru() {
        return validThru;
    }

    public void setValidThru(Date validThru) {
        this.validThru = validThru;
    }

    public Short getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(Short securityCode) {
        this.securityCode = securityCode;
    }
}