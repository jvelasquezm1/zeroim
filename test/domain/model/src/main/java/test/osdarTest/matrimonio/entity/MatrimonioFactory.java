package test.osdarTest.matrimonio.entity;

import test.osdarTest.contrayente.entity.Contrayente;
import test.osdarTest.generic.GenerateUniqueId;
import test.osdarTest.maestros.entity.Iglesia;
import test.osdarTest.maestros.entity.Pastor;

import java.util.Date;
import java.util.List;

public interface MatrimonioFactory extends GenerateUniqueId {

    default Matrimonio createMatrimonio(
            List<Contrayente> contrayentes,
            Iglesia iglesia,
            Pastor pastor,
            Date fecha,
            String marriageRegistrationNumber,
            String notaria,
            String actaNumber
    ) {
        return Matrimonio.builder()
                .id(generateObjectId())
                .contrayentes(contrayentes)
                .iglesia(iglesia)
                .pastor(pastor)
                .fecha(fecha)
                .marriageRegistrationNumber(marriageRegistrationNumber)
                .notaria(notaria)
                .actaNumber(actaNumber)
                .build();
    }
}
