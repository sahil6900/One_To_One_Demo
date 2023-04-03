package com.demo.spring_jpa_understanding_with_mappings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.demo.spring_jpa_understanding_with_mappings.repo")
public class SpringJpaUnderstandingWithMappingsApplication {

    public static void main (String[] args) {
        SpringApplication.run (SpringJpaUnderstandingWithMappingsApplication.class , args);
    }

}
