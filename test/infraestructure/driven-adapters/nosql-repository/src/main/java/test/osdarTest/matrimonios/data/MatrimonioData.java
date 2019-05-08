package test.osdarTest.matrimonios.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import test.osdarTest.contrayente.entity.Contrayente;
import test.osdarTest.maestros.entity.Iglesia;
import test.osdarTest.maestros.entity.Notaria;
import test.osdarTest.maestros.entity.Pastor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Matrimonios")
public class MatrimonioData {

    @Id
    private String id;
    private List<Contrayente> contrayentes;
    private Iglesia iglesia;
    private Pastor pastor;
    private Date fecha;
    private String marriageRegistrationNumber;
    private String notaria;
    private String actaNumnber;

}
