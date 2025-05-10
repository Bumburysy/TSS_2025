package com.tss.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ApplicationConfig {
    /**
     * Konfiguracja OpenAPI - tytuł, opis, wersja i serwery.
     * @return 
    */
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Moje API Produktów")  // Tytuł dokumentacji
                        .description("API do zarządzania produktami w systemie.")  // Opis dokumentacji
                        .version("1.0.0")  // Wersja API
                        .termsOfService("https://www.example.com/terms")  // Warunki korzystania
                        .contact(new Contact()  // Dane kontaktowe
                                .name("Nyk Michal")
                                .url("https://www.example.com/contact")
                                .email("Nyk.Michal@example.com")
                        )
                )
                .addServersItem(new Server()
                        .url("http://localhost:8080")  // URL serwera
                        .description("Serwer lokalny")
                );
    }
}
