package com.github.abdullahprasetio;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class DemoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
  	public OpenAPI springShopOpenAPI() {
      return new OpenAPI()
              .info(new Info().title("Springboot MyAPI By Temancode")
              .description("Spring sample application")
              .version("v0.0.1")
			  .contact(new Contact().name("Waluyo Ade Prasetio").email("temancode@gmail.com").url("https://github.com/abdullahPrasetio"))
              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
              .externalDocs(new ExternalDocumentation()
              .description("Temancode repository")
              .url("https://github.com/abdullahPrasetio"));
  }

}
