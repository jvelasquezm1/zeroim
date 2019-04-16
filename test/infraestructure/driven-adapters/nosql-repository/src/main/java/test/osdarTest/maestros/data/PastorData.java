package test.osdarTest.maestros.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import test.osdarTest.maestros.entity.DocumentoIdentidad;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Pastores")
public class PastorData {

    @Id
    private String id;
    private String names;
    private String lastNames;
    private String documentNumber;
    private DocumentoIdentidad documentType;

}
