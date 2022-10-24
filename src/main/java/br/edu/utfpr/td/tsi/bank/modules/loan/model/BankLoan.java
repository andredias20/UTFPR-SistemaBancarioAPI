package br.edu.utfpr.td.tsi.bank.modules.loan.model;

import java.io.Serializable;

import javax.persistence.*;

import br.edu.utfpr.td.tsi.bank.modules.client.model.Client;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "loan")
public class BankLoan implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    private Long loanValue;
    @Range(min = 0)
    private Integer monthsForPayment;
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
