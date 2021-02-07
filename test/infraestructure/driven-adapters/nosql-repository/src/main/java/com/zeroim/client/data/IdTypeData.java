package com.zeroim.client.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "IdType")
public class IdTypeData {
    private Long id;
    private String abbreviation;
    private String name;
}
