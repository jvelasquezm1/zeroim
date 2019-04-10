package test.osdarTest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.osdarTest.repository.gateway.MaestrosRepository;
import test.osdarTest.repository.usecase.MaestrosUseCase;

@Configuration
public class UseCasesConfiguration {

    @Bean
    public MaestrosUseCase maestrosUseCase(MaestrosRepository maestrosRepository) {
        return new MaestrosUseCase(maestrosRepository);
    }

}
