package rentcar.rentcarbackend.test.cucumber;

import rentcar.rentcarbackend.LearningCenterApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = LearningCenterApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = LearningCenterApplication.class, loader = SpringBootContextLoader.class)
public class CucumberSpringConfiguration {
}
