package test.osdarTest.maestros;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.maestros.entity.DocumentoIdentidad;
import test.osdarTest.maestros.entity.Pastor;
import test.osdarTest.maestros.gateway.MaestrosRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;
import static reactor.core.publisher.Mono.when;

@RunWith(MockitoJUnitRunner.class)
public class PastorUseCaseTest {

    private final String DOCUMENT_NUMBER = "16617401";
    @Mock
    private MaestrosRepository maestrosRepository;

    private MaestrosUseCase maestrosUseCase;

    private DocumentoIdentidad documentoIdentidad = DocumentoIdentidad.builder()
            .id("1")
            .idType("CC")
            .name("Cédula de Ciudadanía")
            .build();

    private Pastor pastor = Pastor.builder()
            .id("1")
            .names("Oscar Manuel")
            .lastNames("Velásquez Marmolejo")
            .documentNumber(DOCUMENT_NUMBER)
            .documentType(documentoIdentidad)
            .build();

    @Before
    public void setup() {
        initMocks(this);
        maestrosUseCase = new MaestrosUseCase(maestrosRepository);
    }

    @Test
    public void shouldGetPastorByDocumentNumber() {
        when(maestrosRepository.getPastorByCedula(DOCUMENT_NUMBER)).thenReturn(Mono.just(pastor));

        Mono<Pastor> pastorMono = maestrosUseCase.getPastorByIdDocument(DOCUMENT_NUMBER);

        Assert.assertEquals(pastorMono, Mono.just(pastor));
    }

    @Test
    public void shouldGetAllPastores() {
        Pastor pastor1 = Pastor.builder()
                .id("2")
                .names("Pastor 2")
                .lastNames("Apellidos pastor2")
                .documentNumber(DOCUMENT_NUMBER)
                .documentType(documentoIdentidad)
                .build();
        Pastor pastor2 = Pastor.builder()
                .id("3")
                .names("Pastor 3")
                .lastNames("Apellidos pastor3")
                .documentNumber(DOCUMENT_NUMBER)
                .documentType(documentoIdentidad)
                .build();
        Pastor pastor3 = Pastor.builder()
                .id("4")
                .names("Pastor 4")
                .lastNames("Apellidos pastor4")
                .documentNumber(DOCUMENT_NUMBER)
                .documentType(documentoIdentidad)
                .build();
        List<Pastor> pastors = new ArrayList<>();
        pastors.add(pastor1);
        pastors.add(pastor2);
        pastors.add(pastor3);

        Flux<Pastor> pastorFlux = Flux.fromIterable(pastors);

        when(maestrosRepository.getPastores()).thenReturn(pastorFlux);

        Flux<Pastor> pastoresFluxUseCase = maestrosUseCase.getPastores();

        Assert.assertEquals(pastorFlux, pastoresFluxUseCase);

    }
}
