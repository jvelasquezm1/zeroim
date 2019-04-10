package test.osdarTest.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Pastores {

    private String id;
    private String names;
    private String lastNames;
    private String idDocument;

}
