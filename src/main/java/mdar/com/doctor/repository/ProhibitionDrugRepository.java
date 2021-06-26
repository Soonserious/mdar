package mdar.com.doctor.repository;

import mdar.com.doctor.Entity.PrescriptionEntity;
import mdar.com.doctor.Entity.ProhibitionDrugEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProhibitionDrugRepository  extends CrudRepository<ProhibitionDrugEntity, Integer> {
    List<ProhibitionDrugEntity> findByPrescription(PrescriptionEntity prescriptionEntity);
    @Transactional
    @Modifying
    @Query("DELETE FROM ProhibitionDrugEntity pd WHERE pd.id IN :ids")
    void deleteAllById(@Param("ids") List<Integer> prohibitionDrugEntityList);
}
