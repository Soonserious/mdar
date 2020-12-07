package mdar.com.user.repository.custom;

import mdar.com.user.dto.UserDTO;
import mdar.com.user.entity.UserEntity;

public interface UserCustomRepository {
    UserEntity findByUserID(UserEntity userEntity);
}
