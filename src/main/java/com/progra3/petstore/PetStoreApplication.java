package com.progra3.petstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class PetStoreApplication {

	
	public static void main(String[] args) {
		SpringApplication.run( PetStoreApplication.class, args);
	}
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.progra3.petstore"))
                .build()
                .apiInfo(apiDetails());
                
    }
	 private ApiInfo apiDetails() {
        return new ApiInfoBuilder()
                .title("Proyecto Final")
                .contact(new Contact("Grupo No. 2","no-url", "UMG"))
                .description("Proyecto Final - Programación III")
                .build();
    }

}
