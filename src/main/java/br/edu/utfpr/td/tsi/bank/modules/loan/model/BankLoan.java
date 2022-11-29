package br.edu.utfpr.td.tsi.bank.modules.loan.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldId;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldNamespace;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldProperty;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;

@JsonldResource
@JsonldNamespace(name = "s", uri = "http://www.semanticweb.org/andre/ontologies/2022/10/BankAccount")
@Entity
@Table(name = "loan")
public class BankLoan implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @JsonldId
    private Integer id;

    @JsonldProperty("s:clientID")
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @JsonldProperty("s:loanValue")
    private Long loanValue;

    @JsonldProperty("s:monthsPercentage")
    @Range(min = 0)
    private Integer monthsForPayment;

    @JsonldProperty("s:taxPercentage")
    @Range(min = 0, max = 100, message = "Tax Percentage needs to be from 0 to 100")
    private Double taxPercentage;

    public BankLoan() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
