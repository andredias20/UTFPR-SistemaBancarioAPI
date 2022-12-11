package br.edu.utfpr.td.tsi.bank.modules.client.model;

import ioinformarics.oss.jackson.module.jsonld.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@JsonldResource
@JsonldNamespace(name = "s", uri = "http://schema.org/")
@JsonldType("s:Person")
@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @JsonldId
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;


    @Column(name = "cpf", nullable = false)
    //@JsonldProperty("@id")
    String cpf;


    @Column(length = 70)
    @NotBlank(message = "Name is mandatory")
    @JsonldProperty("s:givenName")
    String first_name;
 

    @Column(length = 100)
    @JsonldProperty("s:familyName")
    String last_name;

    @JsonldProperty("s:birthDate")
    Date birthDate;

    @Email(message = "Email is not valid")
    @NotEmpty(message = "Email is mandatory")
    String email;

    @JsonldProperty("s:telephone")
    @NotBlank(message = "Phone is mandatory")
    String phone;

    @JsonldProperty("s:estimatedSalary")
    Double salary;


    //@JsonldProperty("")
    //String accountLink;


    public Client() {}

    public Client(String cpf){
        this.cpf = cpf;
    }


    /*
    public Client(int id){
        this.id = id;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    @Override
    public String toString() {
        return "Client{" +
                "cpf='" + cpf + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                '}';
    }
}
