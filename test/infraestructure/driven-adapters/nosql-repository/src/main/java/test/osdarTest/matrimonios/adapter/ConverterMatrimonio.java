package test.osdarTest.matrimonios.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactive.mapper.ObjectMapper;
import test.osdarTest.matrimonio.entity.Matrimonio;
import test.osdarTest.matrimonios.data.MatrimonioData;

@Component
public class ConverterMatrimonio {

    @Autowired
    ObjectMapper mapper;

    public Matrimonio toEntity(MatrimonioData matrimonioData) {
        return mapper.map(matrimonioData, Matrimonio.class);
    }

    public MatrimonioData toData(Matrimonio matrimonio) {
        return mapper.map(matrimonio, MatrimonioData.class);
    }

}
