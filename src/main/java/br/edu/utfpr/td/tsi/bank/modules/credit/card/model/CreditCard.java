package br.edu.utfpr.td.tsi.bank.modules.credit.card.model;

import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "credit_card")
public class CreditCard implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @NotBlank(message = "ClientID is mandatory")
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client clientID;
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

    public Client getClientID() {
        return clientID;
    }

    public void setClientID(Client clientID) {
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
