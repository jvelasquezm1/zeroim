package test.osdarTest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.osdarTest.contrayente.entity.Contrayente;
import test.osdarTest.contrayente.ContrayenteUseCase;

@RestController
@CrossOrigin(value = "*")
public class ContrayenteController {

    @Autowired
    private ContrayenteUseCase contrayenteUseCase;

    @PostMapping("/contrayente/nuevo")
    public Mono<Contrayente> saveContrayente(@RequestBody Contrayente contrayente) {
        return contrayenteUseCase.saveContrayente(contrayente);
    }

    @GetMapping("/contrayentes")
    public Flux<Contrayente> getAllContrayentes() {
        return contrayenteUseCase.getAllContrayentes();
    }

    @GetMapping("contrayente/{documentNumber}")
    public Mono<Contrayente> getContrayenteByDocumentNumber(@PathVariable String documentNumber) {
        return contrayenteUseCase.getContrayenteByDocumentNumber(documentNumber);
    }
}
