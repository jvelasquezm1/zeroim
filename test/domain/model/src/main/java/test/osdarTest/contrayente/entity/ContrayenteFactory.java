package test.osdarTest.contrayente.entity;

import test.osdarTest.generic.GenerateUniqueId;

public interface ContrayenteFactory extends GenerateUniqueId {

    default Contrayente createContrayente(
            String names,
            String lastNames,
            String documentTypePK,
            String documentNumber,
            String civilRegistrationNumber,
            String notariaPK
    ) {
        return Contrayente.builder()
                .id(generateObjectId())
                .names(names)
                .lastNames(lastNames)
                .documentTypePK(documentTypePK)
                .documentNumber(documentNumber)
                .civilRegistrationNumber(civilRegistrationNumber)
                .notariaPK(notariaPK)
                .build();
    }
}
