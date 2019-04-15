package test.osdarTest.maestros.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "DocumentoIdentidad")
public class DocumentoIdentidadData {

    @Id
    private String id;
    private String idType;
    private String name;

}
