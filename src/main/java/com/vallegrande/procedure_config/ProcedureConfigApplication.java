package com.vallegrande.procedure_config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableReactiveFeignClients
public class ProcedureConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcedureConfigApplication.class, args);
    }

    @Bean
    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(new ClassPathResource("data.sql"));
        initializer.setDatabasePopulator(populator);
        return initializer;
    }

}
