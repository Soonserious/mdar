package mdar.com.user.entity.enumEntity.converter.db;

import mdar.com.user.entity.enumEntity.Hospital;

import javax.persistence.AttributeConverter;

public class HospitalConverter implements AttributeConverter<Hospital,Integer> {
    @Override
    public Integer convertToDatabaseColumn(Hospital hospital) {
        return hospital.getOrder();
    }

    @Override
    public Hospital convertToEntityAttribute(Integer integer) {
        for(Hospital hospital : Hospital.values()){
            if(hospital.getOrder() == integer){
                return hospital;
            }
        }
        return Hospital.ChungBuk;
    }
}
