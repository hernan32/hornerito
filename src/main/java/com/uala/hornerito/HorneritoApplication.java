package com.uala.hornerito;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Hornerito API", version = "1.0", description = "Hornerito Backend API"))
@ComponentScan("com.uala.*")
@EnableJpaRepositories(basePackages = "com.uala.hornerito.repository")
public class HorneritoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HorneritoApplication.class, args);
    }

}
