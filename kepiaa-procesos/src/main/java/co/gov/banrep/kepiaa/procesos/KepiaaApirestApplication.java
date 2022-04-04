package co.gov.banrep.kepiaa.procesos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages  ="co.gov.banrep.kepiaa")
@OpenAPIDefinition
public class KepiaaApirestApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(KepiaaApirestApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(KepiaaApirestApplication.class, args);
    }

}
