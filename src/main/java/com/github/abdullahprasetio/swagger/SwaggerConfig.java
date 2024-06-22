package com.github.abdullahprasetio.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@OpenAPIDefinition(
    info = @io.swagger.v3.oas.annotations.info.Info(
        title = "Springboot MyAPI By Temancode",
        version = "v0.0.1",
        description = "Spring sample application",
        contact = @io.swagger.v3.oas.annotations.info.Contact(name = "Waluyo Ade Prasetio", email = "temancode@gmail.com", url = "https://github.com/abdullahPrasetio"),
        license = @io.swagger.v3.oas.annotations.info.License(name = "Apache 2.0", url = "http://springdoc.org")
    ),
    servers = @Server(url = "http://localhost:8080"),
    security = @SecurityRequirement(name = "basicAuth")
)
@SecurityScheme(
    name = "basicAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "basic"
)
public class SwaggerConfig {
    @Bean
  	public OpenAPI springShopOpenAPI() {
      return new OpenAPI().components(new Components())
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
