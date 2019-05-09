package test.osdarTest.contrayente.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.osdarTest.maestros.entity.DocumentoIdentidad;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Contrayente {

    private String id;
    private String names;
    private String lastNames;
    private String documentNumber;
    private DocumentoIdentidad documentType;
    private String civilRegistrationNumber;
    private String notaria;

}
