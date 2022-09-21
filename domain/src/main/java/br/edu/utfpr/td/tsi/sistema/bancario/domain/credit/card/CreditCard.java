package br.edu.utfpr.td.tsi.sistema.bancario.domain.credit.card;

import java.io.Serializable;
import java.util.Date;

public class CreditCard implements Serializable {

    private Integer id;
    private Integer clientID;
    private String cardHolder;
    private Long cardNumber;
    private Date validThru;
    private Short securityCode;

    public CreditCard(Integer id, Integer clientID, String cardHolder, Long cardNumber, Date validThru, Short securityCode) {
        this.id = id;
        this.clientID = clientID;
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.validThru = validThru;
        this.securityCode = securityCode;
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
