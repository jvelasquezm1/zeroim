package test.osdarTest.contrayente.entity;

import test.osdarTest.generic.GenerateUniqueId;
import test.osdarTest.maestros.entity.Notaria;

public interface ContrayenteFactory extends GenerateUniqueId{

    default  Contrayente createContrayente(String names, String lastNames, String cedula,
                                           String civilRegistrationNumber, Notaria notaria) {
        return Contrayente.builder()
                .id(generateObjectId())
                .names(names)
                .lastNames(lastNames)
                .cedula(cedula)
                .civilRegistrationNumber(civilRegistrationNumber)
                .notaria(notaria)
                .build();
    }
}
