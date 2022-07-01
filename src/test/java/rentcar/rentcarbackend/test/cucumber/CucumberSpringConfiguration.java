package rentcar.rentcarbackend.test.cucumber;

import rentcar.rentcarbackend.RentcarBackendApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = RentcarBackendApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = RentcarBackendApplication.class, loader = SpringBootContextLoader.class)
public class CucumberSpringConfiguration {
}
