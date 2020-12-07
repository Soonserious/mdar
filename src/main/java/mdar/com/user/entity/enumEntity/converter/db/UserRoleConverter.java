package mdar.com.user.entity.enumEntity.converter.db;

import mdar.com.user.entity.enumEntity.UserRole;

import javax.persistence.AttributeConverter;

public class UserRoleConverter implements AttributeConverter<UserRole,Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserRole userRole) {
        return userRole.ordinal();
    }

    @Override
    public UserRole convertToEntityAttribute(Integer integer) {
        for(UserRole userRole : UserRole.values()){
            if(userRole.ordinal() == integer){
                return userRole;
            }
        }
        return null;
    }
}
