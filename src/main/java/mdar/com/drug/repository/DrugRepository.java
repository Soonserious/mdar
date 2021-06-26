package mdar.com.doctor.repository;

import mdar.com.doctor.Entity.DrugEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface DrugRepository extends CrudRepository<DrugEntity, Integer> {
    Page<DrugEntity> findAll(Pageable of);

    Page<DrugEntity> findAllByItemName(String searchValue, Pageable of);

    Page<DrugEntity> findAllByItemSeq(String searchValue, Pageable of);
}
