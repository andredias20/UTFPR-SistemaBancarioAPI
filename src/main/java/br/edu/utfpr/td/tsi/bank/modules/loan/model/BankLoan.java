package br.edu.utfpr.td.tsi.bank.modules.loan.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "loan")
public class BankLoan implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(targetEntity= Client.class)
    private Integer client;
    private Long loanValue;
    private Integer monthsForPayment;
    private Double taxPercentage;

    public BankLoan() {
    }

    public BankLoan(Integer id, Integer clientID, Long loanValue, Integer monthsForPayment, Double taxPercentage) {
        this.id = id;
        this.client = clientID;
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

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer clientID) {
        this.client = clientID;
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
