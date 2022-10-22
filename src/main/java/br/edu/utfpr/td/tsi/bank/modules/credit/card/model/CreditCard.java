package br.edu.utfpr.td.tsi.bank.modules.credit.card.model;

import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "credit_card")
public class CreditCard implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(targetEntity = Client.class)
    @NotBlank(message = "ClientID is mandatory")
    private Integer clientID;
    @NotBlank(message = "Card Holder is mandatory")
    private String cardHolder;
    @NotBlank(message = "Card number is mandatory")
    private Long cardNumber;
    @NotBlank(message = "ValidThru is mandatory")
    private Date validThru;
    @NotBlank(message = "Security code is mandatory")
    private Short securityCode;

    public CreditCard() {}

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
