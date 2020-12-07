package mdar.com.doctor.repository;

import mdar.com.doctor.Entity.ClinicEntity;
import mdar.com.doctor.Entity.PrescriptionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrescriptionRepository extends CrudRepository<PrescriptionEntity, Integer> {
    Page<PrescriptionEntity> findByClinicEntity(ClinicEntity toEntity, Pageable of);
}
