package mdar.com.user.entity;


import lombok.*;
import mdar.com.user.dto.UserDTO;
import mdar.com.user.dto.UserRoleDTO;
import mdar.com.user.entity.enumEntity.UserRole;
import mdar.com.user.entity.enumEntity.converter.db.UserRoleConverter;
import mdar.com.util.Util;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="user_role")
@Builder(builderMethodName = "builder")
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Convert(converter = UserRoleConverter.class)
    @Column(name ="userRole", columnDefinition = "int")
    private UserRole userRole;

    @ManyToOne(targetEntity = UserEntity.class,fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserEntity userEntity;


    public static UserRoleEntity toEntity(UserRoleDTO userRoleDTO){
        UserRoleEntity userRoleEntity = Util.getInstance().getMapper().map(userRoleDTO,UserRoleEntity.class);
        return userRoleEntity;
    }
}
