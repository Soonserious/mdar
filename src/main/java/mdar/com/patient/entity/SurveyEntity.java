package mdar.com.patient.entity;

import lombok.*;
import mdar.com.drug.Entity.DrugEntity;
import mdar.com.drug.dto.DrugDTO;
import mdar.com.user.dto.UserDTO;
import mdar.com.user.entity.UserEntity;
import mdar.com.util.LocalDateTimeAttributeConverter;
import mdar.com.util.Util;
import org.hibernate.annotations.CreationTimestamp;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "survey")
public class SurveyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "used_date")
    @CreationTimestamp
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime usedDate;

    public static SurveyEntity toEntity(SurveyDTO surveyDTO) {
         ModelMapper modelmapper = Util.getInstance().getMapper();
         modelmapper.addConverter(new AbstractConverter<UserEntity, UserDTO>() {
             @Override
             protected UserDTO convert(UserEntity userEntity) {
                 return UserDTO.toDTO(userEntity);
             }
         });
         modelmapper.addConverter(new AbstractConverter<DrugEntity, DrugDTO>() {
             @Override
             protected DrugDTO convert(DrugEntity drugEntity) {
                 return DrugDTO.toDTO(drugEntity);
             }
         });
         return modelmapper.map(surveyDTO, SurveyEntity.class);
    }
}
