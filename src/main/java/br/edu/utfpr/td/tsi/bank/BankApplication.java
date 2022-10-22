package br.edu.utfpr.td.tsi.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(value = "br.edu.utfpr.td.tsi.bank")
@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = "br.edu.utfpr.td.tsi.bank.*")
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

}
