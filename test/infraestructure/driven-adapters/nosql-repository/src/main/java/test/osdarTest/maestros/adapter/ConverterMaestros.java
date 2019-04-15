package test.osdarTest.maestros.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactive.mapper.ObjectMapper;
import test.osdarTest.generic.ObjectMapperDomain;
import test.osdarTest.maestros.data.DocumentoIdentidadData;
import test.osdarTest.maestros.entity.DocumentoIdentidad;
import test.osdarTest.maestros.entity.Iglesia;
import test.osdarTest.maestros.entity.Notaria;
import test.osdarTest.maestros.entity.Pastor;
import test.osdarTest.maestros.data.IglesiaData;
import test.osdarTest.maestros.data.NotariaData;
import test.osdarTest.maestros.data.PastorData;

@Component
public class ConverterMaestros implements ObjectMapperDomain {

    @Autowired
    private ObjectMapper mapper;

    public Pastor toEntity(PastorData pastoresData) {
        return mapper.map(pastoresData, Pastor.class);
    }

    public PastorData toData(Pastor pastor) {
        return mapper.map(pastor, PastorData.class);
    }

    public Iglesia toEntity(IglesiaData iglesiaData) {
        return mapper.map(iglesiaData, Iglesia.class);
    }

    public IglesiaData toData(Iglesia iglesia) {
        return mapper.map(iglesia, IglesiaData.class);
    }

    public Notaria toEntity(NotariaData notariaData){ return mapper.map(notariaData, Notaria.class); }

    public NotariaData toData(Notaria notaria) {
        return mapper.map(notaria, NotariaData.class);
    }

    public DocumentoIdentidad toEntity(DocumentoIdentidadData documentoIdentidadData) {
        return mapper.map(documentoIdentidadData, DocumentoIdentidad.class);
    }

    public DocumentoIdentidadData toData(DocumentoIdentidad documentoIdentidad) {
        return mapper.map(documentoIdentidad, DocumentoIdentidadData.class);
    }
}