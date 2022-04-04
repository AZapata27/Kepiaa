package co.gov.banrep.kepiaa.commons.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

   @Bean
    public OpenAPI springKepiaOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Kepiaa API")
                        .description("Esta es la documentacion de la api de " +
                                "Kepiaa, encontrara toda la informacion necesaria para realizar pruebas" +
                                " y tener un contexto general de su consumo.")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }


}
