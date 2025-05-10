package com.tss.Zadanie8NykMichal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages={"com.tss"})
public class Zadanie8NykMichalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Zadanie8NykMichalApplication.class, args);
	}

        @LoadBalanced
        @Bean
        public RestTemplate getRestTemplate(){
            return new RestTemplate();
        }
}
