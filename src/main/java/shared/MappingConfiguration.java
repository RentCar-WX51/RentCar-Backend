package shared;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhanceModelMapper modelMapper(){
        return new EnhanceModelMapper();
    }
}
