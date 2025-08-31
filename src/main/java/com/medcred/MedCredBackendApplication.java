package com.medcred;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.medcred.repository")
@EntityScan(basePackages = "com.medcred.models")
public class MedCredBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedCredBackendApplication.class, args);
    }

}
