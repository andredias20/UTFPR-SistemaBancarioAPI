package br.edu.utfpr.td.tsi.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "br.edu.utfpr.td.tsi.bank.*")
@EnableJpaRepositories(basePackages = "br.edu.utfpr.td.tsi.bank.*")
@EnableAutoConfiguration
@EntityScan(basePackages = "br.edu.utfpr.td.tsi.bank.*")
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

}
