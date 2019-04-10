package test.osdarTest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.repository.entity.Pastores;
import test.osdarTest.repository.usecase.MaestrosUseCase;

@RestController
@RequestMapping("maestros")
public class MaestrosController {

    @Autowired
    private MaestrosUseCase maestrosUseCase;

    @GetMapping("/pastores")
    public Flux<Pastores> getPastores() {
        return maestrosUseCase.getPastores();
    }

    @GetMapping("/pastor/{idDocument}")
    public Mono<Pastores> getPastorByIdDocument(@PathVariable String idDocument) {
        return maestrosUseCase.getPastoresByIdDocument(idDocument);
    }
}
