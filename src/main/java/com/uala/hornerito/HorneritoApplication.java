package com.uala.hornerito;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Hornerito API", version = "1.0", description = "Hornerito Backend API"))
@ComponentScan("com.uala.*")
public class HorneritoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HorneritoApplication.class, args);
    }

}
