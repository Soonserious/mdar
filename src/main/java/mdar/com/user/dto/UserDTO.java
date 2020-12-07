package mdar.com.user.dto;

import lombok.*;
import mdar.com.user.entity.UserEntity;
import mdar.com.user.entity.enumEntity.Hospital;
import mdar.com.user.entity.enumEntity.Sex;
import mdar.com.user.entity.enumEntity.UserRole;
import mdar.com.util.Util;
import org.modelmapper.ModelMapper;

import java.util.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "builder")
public class UserDTO {
    private int id;
    private String userID;
    private String email;
    private String password;
    @Builder.Default private int phoneNumber = 1;
    private String name;
    private LocalDateTime signinDate;
    private LocalDateTime lastLogin;
    @Builder.Default private Hospital hospital = Hospital.ChungBuk;
    @Builder.Default private Sex sex = Sex.Man;
    private UserRole userRole;


    public static UserDTO toDTO(UserEntity userEntity){
        ModelMapper modelMapper = Util.getInstance().getMapper();
        UserDTO userDTO = modelMapper.map(userEntity,UserDTO.class);
        return userDTO;
    }
}
