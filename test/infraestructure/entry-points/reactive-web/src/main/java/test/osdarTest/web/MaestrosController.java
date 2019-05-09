package test.osdarTest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.maestros.entity.DocumentoIdentidad;
import test.osdarTest.maestros.entity.Iglesia;
import test.osdarTest.maestros.entity.Pastor;
import test.osdarTest.maestros.MaestrosUseCase;

@RestController
@RequestMapping("maestros")
@CrossOrigin(value = "*")
public class MaestrosController {

    @Autowired
    private MaestrosUseCase maestrosUseCase;

    @GetMapping("/pastores")
    public Flux<Pastor> getPastores() {
        return maestrosUseCase.getPastores();
    }

    @GetMapping("/pastor/{idDocument}")
    public Mono<Pastor> getPastorByIdDocument(@PathVariable String idDocument) {
        return maestrosUseCase.getPastorByIdDocument(idDocument);
    }

    @PostMapping("/pastor/nuevo")
    public Mono<Pastor> savePastor(@RequestBody Pastor pastor) {
        return maestrosUseCase.savePastor(pastor);
    }

    @GetMapping("/iglesias")
    public Flux<Iglesia> getIglesias() {
        return maestrosUseCase.getIglesias();
    }

    @GetMapping("/iglesia/{name}")
    public Mono<Iglesia> getIglesiaByName(@PathVariable String name) {
        return maestrosUseCase.getIglesiasByName(name);
    }

    @PostMapping("/iglesia/nueva")
    public Mono<Iglesia> saveIglesia(@RequestBody Iglesia iglesia) {
        return maestrosUseCase.saveIglesia(iglesia);
    }

    @GetMapping("/documentos_identidad")
    public Flux<DocumentoIdentidad> getDocumentosIdentidad() {
        return maestrosUseCase.getDocumentosIdentidad();
    }

    @GetMapping("/documento_identidad/{name}")
    public Mono<DocumentoIdentidad> getDocumentoIdentidadByName(@PathVariable String name) {
        return maestrosUseCase.getDocumentoIdentidadByName(name);
    }

    @GetMapping("/documento/{idType}")
    public Mono<DocumentoIdentidad> getDocumentoIdentidadByIdType(@PathVariable String idType) {
        return maestrosUseCase.getDocumentoIdentidadByIdType(idType);
    }
}
