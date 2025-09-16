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
                        .description("API de ManchApp: consulta, crea y gestiona soluciones para eliminar manchas en diferentes materiales y superficies. Documentación generada automáticamente para facilitar la integración y el desarrollo front.")
                        .contact(new Contact().name("Ana Minguela").email("afminguela@gmail.com"))
                        .license(new License().name("MIT"))
                );
        // Si en el futuro usas JWT, descomenta esto:
        // .components(new Components().addSecuritySchemes("bearer-jwt",
        //     new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
        // .addSecurityItem(new SecurityRequirement().addList("bearer-jwt"));
    }

    // Grupos opcionales (secciones en Swagger UI)


    @Bean
    public GroupedOpenApi solucionLimpiezaGroup() {
        return GroupedOpenApi.builder()
                .group("solucion_limpieza")
                .pathsToMatch("/api/soluciones/**")
                .build();
    }
}