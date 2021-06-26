package mdar.com.patient.repository;

import mdar.com.patient.entity.SurveyDrugEntity;
import mdar.com.patient.entity.UsedDrugByUserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyAboutDrugRepository extends CrudRepository<SurveyDrugEntity, Integer> {
    List<SurveyDrugEntity> findByUsedDrugByUserIn(List<UsedDrugByUserEntity> usedDrugByUserEntityList);
    List<SurveyDrugEntity> findByUsedDrugByUser(UsedDrugByUserEntity usedDrugByUserEntity);

    @Query("SELECT A.id, A.usedDrugByUser, A.siderMeddraFreq, A.word, A.surveyDate FROM survey_about_drug A INNER JOIN DrugEntity B WHERE A.usedDrugByUser = B.id AND B.id = :id")
    List<SurveyDrugEntity> selectSurveyAboutDrugByDrugId(@Param("id") int i);
}
