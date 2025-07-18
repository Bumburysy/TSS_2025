package com.tss.Zadanie3NykMichal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.tss"})
@EnableJpaRepositories(basePackages={"com.tss.repositories"})
@EnableTransactionManagement
@EntityScan(basePackages={"com.tss.entities"})
public class Zadanie3NykMichalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Zadanie3NykMichalApplication.class, args);
	}

}
