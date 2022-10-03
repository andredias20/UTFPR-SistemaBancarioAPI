package br.edu.utfpr.td.tsi.bank.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableAutoConfiguration
public class PersistenceContext {

	@Value("${spring.datasource.driverClassName}")
	private String driver;
	
	@Value("${spring.datasource.username}")
	private String user;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.url}") 
	private String url;
	
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
     
        em.setPackagesToScan(new String[] { "br.edu.utfpr.td.tsi.bank.*" });

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setDataSource(dataSource());
        return em;
    }
	
	@Bean
	public DataSource dataSource(){
		
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(driver);
	    dataSource.setUrl(url);
	    dataSource.setUsername(user);
	    dataSource.setPassword(password);
	    
	    return dataSource;
	}
}
