package mdar.com.user.security;

import mdar.com.user.entity.UserRoleEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityUser extends User {
    public SecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public static List<GrantedAuthority> makingGrantedAuthority(List<UserRoleEntity> userRoles) {
        List<GrantedAuthority> result = new ArrayList<>();
        for(UserRoleEntity userRoleEntity: userRoles){
            result.add(new SimpleGrantedAuthority(userRoleEntity.getUserRole().getRole()));
        }
        return result;
    }
}
