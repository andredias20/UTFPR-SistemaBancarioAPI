package br.edu.utfpr.td.tsi.bank.modules.client.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldId;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldNamespace;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldProperty;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldResource;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;

@JsonldResource
@JsonldNamespace(name = "s", uri = "http://schema.org/")
@JsonldType("s:Person")
@Entity
@Table(name = "client")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonldId
    Integer id;

    @JsonldProperty("s:givenName")
    @Column(length = 70)
    @NotBlank(message = "Name is mandatory")
    String first_name;
 
    @JsonldProperty("s:familyName")
    @Column(length = 100)
    private String last_name;

    @JsonldProperty("s:identifier")
    @Column(unique = true)
    @Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}", message = "Value don't correspond to default value ###.###.###-##, where # is digits 0-9.")
    private String cpf;

    @JsonldProperty("s:birthDate")
    private Date birthDate;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @JsonldProperty("s:telephone")
    @NotBlank(message = "Phone is mandatory")
    String phone;

    @JsonldProperty("s:estimatedSalary")
    Double salary;


    public Client() {}

    public Client(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_Name(String name) {
        this.first_name = first_name;
    }


    public String getLast_Name() {
        return last_name;
    }

    public void setLast_Name(String name) {
        this.last_name = last_name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
