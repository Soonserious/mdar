package mdar.com.drug.repository;

import mdar.com.drug.Entity.MapperATCAndStitchEntity;
import mdar.com.drug.Entity.SiderMeddraEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiderMeddraRepository extends CrudRepository<SiderMeddraEntity, Integer> {
    List<SiderMeddraEntity> findByMapperIDIn(List<MapperATCAndStitchEntity> medicineMapperEntityList);
}
