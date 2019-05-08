package test.osdarTest.contrayentes.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import test.osdarTest.maestros.entity.DocumentoIdentidad;
import test.osdarTest.maestros.entity.Notaria;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Contrayentes")
public class ContrayenteData {

    @Id
    private String id;
    private String names;
    private String lastNames;
    private DocumentoIdentidad documentType;
    private String documentNumber;
    private String civilRegistrationNumber;
    private String notaria;

}
