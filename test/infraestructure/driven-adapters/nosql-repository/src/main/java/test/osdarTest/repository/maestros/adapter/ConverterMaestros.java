package test.osdarTest.repository.maestros.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactive.mapper.ObjectMapper;
import test.osdarTest.generic.ObjectMapperDomain;
import test.osdarTest.repository.entity.Pastores;
import test.osdarTest.repository.maestros.data.PastoresData;

@Component
public class ConverterMaestros implements ObjectMapperDomain {

    @Autowired
    private ObjectMapper mapper;

    public Pastores toEntity(PastoresData pastoresData) {
        return mapper.map(pastoresData, Pastores.class);
    }

    public PastoresData toData(Pastores pastores) {
        return mapper.map(pastores, PastoresData.class);
    }
}
