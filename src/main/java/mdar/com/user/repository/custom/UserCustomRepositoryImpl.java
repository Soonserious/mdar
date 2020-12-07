package mdar.com.user.repository.custom;

import mdar.com.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Repository
@Transactional
public class UserCustomRepositoryImpl implements UserCustomRepository{

    @Autowired
    EntityManager entityManager;
    @Override
    public UserEntity findByUserID(UserEntity userEntity) {
        String query = "SELECT * FROM User AS u WHERE u.userID  = " + userEntity.getUserID() + " AND u.password = " + userEntity.getPassword();
        return entityManager.createQuery(query,UserEntity.class).getSingleResult();
    }
}

