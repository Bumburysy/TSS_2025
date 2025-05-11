package com.tss.bdd;

import com.tss.Zadanie7NykMichal.Zadanie7NykMichalApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = Zadanie7NykMichalApplication.class)
public class CucumberSpringConfiguration {
}