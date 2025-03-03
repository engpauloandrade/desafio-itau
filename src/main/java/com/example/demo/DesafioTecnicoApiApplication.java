package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class DesafioTecnicoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioTecnicoApiApplication.class, args);
	}

}
