package rentcar.rentcarbackend.shared.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI customOpenApi(
            @Value("${documentation.application.description}") String applicationDescription,
            @Value("${documentation.application.version}") String applicationVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("YouSoftware RentCar API")
                        .version(applicationVersion)
                        .description(applicationDescription)
                        .termsOfService("https://rentcar-frontend.web.app/tos")
                        .license(new License().name("Apache 2.0 License").url("https://rentcar-frontend.web.app/license"))
                        );
    }
}
