package test.osdarTest.repository.maestros.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Pastores")
public class PastoresData {

    @Id
    private String id;
    private String names;
    private String lastNames;
    private String idDocument;

}