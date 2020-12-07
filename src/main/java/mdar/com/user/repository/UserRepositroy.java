package mdar.com.user.repository;

import mdar.com.user.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositroy extends CrudRepository<UserEntity,Integer> {
    Optional<UserEntity> findByUserID(String userID);
    List<UserEntity> findByName(String patientName);
    Page<UserEntity> findAll(Pageable pageable);
    Iterable<UserEntity> findAll(Sort sort);

}
