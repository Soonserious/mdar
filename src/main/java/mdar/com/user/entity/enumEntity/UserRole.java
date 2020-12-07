package mdar.com.user.entity.enumEntity;

import lombok.Getter;

@Getter
public enum UserRole {
    Admin("ROLE_ADMIN"),
    Doctor("ROLE_DOCTOR"),
    Patient("ROLE_PATIENT");

    private String role;
    private UserRole(String role){
       this.role = role;
    }
}

