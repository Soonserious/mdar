package mdar.com.user.entity.enumEntity.converter.db;

import mdar.com.user.entity.enumEntity.Sex;

import javax.persistence.AttributeConverter;

public class SexConverter implements AttributeConverter<Sex, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Sex sex) {
        return sex.getOrder();
    }

    @Override
    public Sex convertToEntityAttribute(Integer integer) {
        for(Sex sex : Sex.values()){
            if(sex.getOrder() == integer){
                return sex;
            }
        }
        return null;
    }
}
