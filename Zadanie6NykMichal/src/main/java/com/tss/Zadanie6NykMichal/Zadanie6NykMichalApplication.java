package com.tss.Zadanie6NykMichal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.tss"})
public class Zadanie6NykMichalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Zadanie6NykMichalApplication.class, args);
	}

}
