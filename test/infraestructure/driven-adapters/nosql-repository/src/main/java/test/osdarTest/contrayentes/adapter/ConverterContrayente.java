package test.osdarTest.contrayentes.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactive.mapper.ObjectMapper;
import test.osdarTest.contrayente.entity.Contrayente;
import test.osdarTest.contrayentes.data.ContrayenteData;

@Component
public class ConverterContrayente {

    @Autowired
    ObjectMapper mapper;

    public Contrayente toEntity(ContrayenteData contrayenteData) {
        return mapper.map(contrayenteData, Contrayente.class);
    }

    public ContrayenteData toData(Contrayente contrayente) {
        return mapper.map(contrayente, ContrayenteData.class);
    }
}
