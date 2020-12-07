package mdar.com.user.entity.enumEntity.converter.html;

import mdar.com.user.entity.enumEntity.UserRole;
import org.springframework.core.convert.converter.Converter;

public class StringToUserRole implements Converter<String, UserRole> {
    @Override
    public UserRole convert(String s) {
        return UserRole.valueOf(s);
    }
}
