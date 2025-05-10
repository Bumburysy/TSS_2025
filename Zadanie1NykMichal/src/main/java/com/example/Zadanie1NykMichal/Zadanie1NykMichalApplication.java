package com.example.Zadanie1NykMichal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.tss.controllers"})
public class Zadanie1NykMichalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Zadanie1NykMichalApplication.class, args);
	}

}
