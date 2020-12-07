package mdar.com.user.repository;

import mdar.com.user.entity.UserEntity;
import mdar.com.user.entity.UserRoleEntity;
import mdar.com.user.entity.enumEntity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {
    public List<UserRoleEntity> findByUserEntity(UserEntity userEntity);
}
