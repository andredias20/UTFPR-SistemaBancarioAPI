package br.edu.utfpr.td.tsi.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.TimeZone;

@EntityScan(value = "br.edu.utfpr.td.tsi.bank")
@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = "br.edu.utfpr.td.tsi.bank.*")
public class BankApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("america/sao_paulo"));
		SpringApplication.run(BankApplication.class, args);
	}


}
