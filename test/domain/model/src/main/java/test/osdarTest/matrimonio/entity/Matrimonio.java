package test.osdarTest.matrimonio.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.osdarTest.contrayente.entity.Contrayente;
import test.osdarTest.maestros.entity.Iglesia;
import test.osdarTest.maestros.entity.Pastor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Matrimonio {

    private String id;
    private List<Contrayente> contrayentes;
    private Iglesia iglesia;
    private Pastor pastor;
    private Date fecha;
    private String marriageRegistrationNumber;
    private String notaria;
    private String actaNumber;

}
