package mdar.com.user.dto;


import lombok.*;
import mdar.com.user.entity.UserEntity;
import mdar.com.user.entity.UserRoleEntity;
import mdar.com.user.entity.enumEntity.UserRole;
import mdar.com.util.Util;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoleDTO {
    int id;
    UserEntity userEntity;
    UserRole userRole;

    public static UserRoleDTO toDTO(UserRoleEntity userRoleEntity){
        ModelMapper modelMapper = Util.getInstance().getMapper();
        UserRoleDTO userRoleDTO = modelMapper.map(userRoleEntity,UserRoleDTO.class);
        return userRoleDTO;
    }

    public static List<UserRoleDTO> makingUserRoleDTOs(String[] userRoles) {
        List<UserRoleDTO> userRoleDTOList = new ArrayList<>();
        for(String strRole : userRoles){
            UserRoleDTO userRoleDTO = UserRoleDTO.builder().userRole(UserRole.valueOf(strRole)).build();
            userRoleDTOList.add(userRoleDTO);
        }
        return userRoleDTOList;
    }
}
