package br.edu.utfpr.td.tsi.sistema.bancario.domain.bank.loan;

import br.edu.utfpr.td.tsi.sistema.bancario.domain.client.Client;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "loan")
public class BankLoan implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(targetEntity= Client.class)
    private Integer clientID;
    private Long loanValue;
    private Integer monthsForPayment;
    private Double taxPercentage;

    public BankLoan() {
    }

    public BankLoan(Integer id, Integer clientID, Long loanValue, Integer monthsForPayment, Double taxPercentage) {
        this.id = id;
        this.clientID = clientID;
        this.loanValue = loanValue;
        this.monthsForPayment = monthsForPayment;
        this.taxPercentage = taxPercentage;
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

    public Long getLoanValue() {
        return loanValue;
    }

    public void setLoanValue(Long loanValue) {
        this.loanValue = loanValue;
    }

    public Integer getMonthsForPayment() {
        return monthsForPayment;
    }

    public void setMonthsForPayment(Integer monthsForPayment) {
        this.monthsForPayment = monthsForPayment;
    }

    public Double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }
}
