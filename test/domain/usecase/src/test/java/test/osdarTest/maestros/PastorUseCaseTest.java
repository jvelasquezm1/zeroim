package test.osdarTest.maestros;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import test.osdarTest.maestros.entity.DocumentoIdentidad;
import test.osdarTest.maestros.entity.Pastor;
import test.osdarTest.maestros.gateway.MaestrosRepository;

import static reactor.core.publisher.Mono.when;

@RunWith(MockitoJUnitRunner.class)
public class PastorUseCaseTest {

    @Mock
    private MaestrosRepository maestrosRepository;

    @InjectMocks
    private MaestrosUseCase maestrosUseCase;

    private final String DOCUMENT_NUMBER = "16617401";

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

    @Test
    public void shouldGetPastorByDocumentNumber() {
        when(maestrosRepository.getPastorByCedula(DOCUMENT_NUMBER)).thenReturn(pastor);
    }
}
