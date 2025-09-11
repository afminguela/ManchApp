package com.adulting101.ManchApp.config;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ManchApp API")
                        .version("v1")
                        .description("Api de resolución de manchas).")
                        .contact(new Contact().name("Ana").email("afminguela@gmail.com"))
                        .license(new License().name("MIT"))
                );
        // Si en el futuro usas JWT, descomenta esto:
        // .components(new Components().addSecuritySchemes("bearer-jwt",
        //     new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
        // .addSecurityItem(new SecurityRequirement().addList("bearer-jwt"));
    }

    // Grupos opcionales (secciones en Swagger UI)


    @Bean
    public GroupedOpenApi SolucionLimpieza() {
        return GroupedOpenApi.builder()
                .group("solucion_limpieza")
                .pathsToMatch("/api/soluciones/**")
                .build();
    }
}