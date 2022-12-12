package br.edu.utfpr.td.tsi.bank.config;

import ioinformarics.oss.jackson.module.jsonld.JsonldModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperContext {

    /*
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder ->
                builder.modules(new JsonldModule());
    }
    */


}
