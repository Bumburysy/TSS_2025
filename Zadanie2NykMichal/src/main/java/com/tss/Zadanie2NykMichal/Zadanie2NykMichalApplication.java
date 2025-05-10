package com.tss.Zadanie2NykMichal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.tss.Zadanie2NykMichal"})
public class Zadanie2NykMichalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Zadanie2NykMichalApplication.class, args);
	}

}
