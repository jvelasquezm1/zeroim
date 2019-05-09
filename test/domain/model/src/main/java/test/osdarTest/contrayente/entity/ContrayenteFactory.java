package test.osdarTest.contrayente.entity;

import test.osdarTest.generic.GenerateUniqueId;
import test.osdarTest.maestros.entity.DocumentoIdentidad;

public interface ContrayenteFactory extends GenerateUniqueId {

    default Contrayente createContrayente(
            String names,
            String lastNames,
            DocumentoIdentidad documentType,
            String documentNumber,
            String civilRegistrationNumber,
            String notaria
    ) {
        return Contrayente.builder()
                .id(generateObjectId())
                .names(names)
                .lastNames(lastNames)
                .documentType(documentType)
                .documentNumber(documentNumber)
                .civilRegistrationNumber(civilRegistrationNumber)
                .notaria(notaria)
                .build();
    }
}
