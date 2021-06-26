package mdar.com.patient.repository;

import mdar.com.patient.entity.UsedDrugByUserEntity;
import mdar.com.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsedDrugByUserRepository extends CrudRepository<UsedDrugByUserEntity,Integer> {
    List<UsedDrugByUserEntity> findByUser(UserEntity toEntity);
}
