package test.osdarTest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.osdarTest.matrimonio.MatrimonioUseCase;
import test.osdarTest.contrayente.gateway.ContrayenteRepository;
import test.osdarTest.contrayente.ContrayenteUseCase;
import test.osdarTest.maestros.gateway.MaestrosRepository;
import test.osdarTest.maestros.MaestrosUseCase;
import test.osdarTest.matrimonio.gateway.MatrimonioRepository;

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

    @Bean
    public MatrimonioUseCase matrimonioUseCase(MatrimonioRepository matrimonioRepository, ContrayenteRepository contrayenteRepository) {
        return new MatrimonioUseCase(matrimonioRepository, contrayenteRepository);
    }

}
