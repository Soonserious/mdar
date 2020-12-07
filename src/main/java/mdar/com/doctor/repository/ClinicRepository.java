package mdar.com.doctor.repository;

import mdar.com.doctor.Entity.ClinicEntity;
import mdar.com.user.dto.UserDTO;
import mdar.com.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ClinicRepository extends CrudRepository<ClinicEntity, Integer> {
    List<ClinicEntity> findByDoctor(UserEntity toEntity);
    ClinicEntity findByDoctorAndPatient(UserEntity toEntity, UserEntity toEntity1);
}
