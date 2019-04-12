package test.osdarTest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.osdarTest.contrayente.gateway.ContrayenteRepository;
import test.osdarTest.contrayente.ContrayenteUseCase;
import test.osdarTest.maestros.gateway.MaestrosRepository;
import test.osdarTest.maestros.usecase.MaestrosUseCase;

@Configuration
public class UseCasesConfiguration {

    @Bean
    public MaestrosUseCase maestrosUseCase(MaestrosRepository maestrosRepository) {
        return new MaestrosUseCase(maestrosRepository);
    }

    @Bean
    public ContrayenteUseCase contrayenteUseCase(ContrayenteRepository contrayenteRepository) {
        return new ContrayenteUseCase(contrayenteRepository);
    }

}
