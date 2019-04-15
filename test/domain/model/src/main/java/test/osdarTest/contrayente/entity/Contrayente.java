package test.osdarTest.contrayente.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.osdarTest.maestros.entity.DocumentoIdentidad;
import test.osdarTest.maestros.entity.Notaria;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Contrayente {

    private String id;
    private String names;
    private String lastNames;
    private String documentTypePK;
    private String documentNumber;
    private String civilRegistrationNumber;
    private String notariaPK;

}
