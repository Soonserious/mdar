package mdar.com.patient.entity;

import lombok.*;
import mdar.com.drug.Entity.SiderMeddraFreqEntity;
import mdar.com.util.LocalDateTimeAttributeConverter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "survey_about_drug")
public class SurveyAboutDrugEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "used_drug_id")
    private UsedDrugByUserEntity usedDrugByUser;

    @ManyToOne
    @JoinColumn(name = "sider_meddra_feq_id")
    private SiderMeddraFreqEntity siderMeddraFreq;

    @Column(name = "word_by_user")
    private String word;

    @Column(name = "survey_date")
    @CreationTimestamp
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime surveyDate;

}
