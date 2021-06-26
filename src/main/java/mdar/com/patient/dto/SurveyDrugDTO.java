package mdar.com.patient.dto;

import lombok.*;
import mdar.com.drug.Entity.SiderMeddraFreqEntity;
import mdar.com.drug.dto.SiderMeddraFreqDTO;
import mdar.com.patient.entity.SurveyAboutDrugEntity;
import mdar.com.patient.entity.UsedDrugByUserEntity;
import mdar.com.util.Util;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyAboutDrugDTO {
    private int id;
    private SurveyDTO usedDrugByUser;
    private SiderMeddraFreqDTO siderMeddraFreq;
    private String word;
    private LocalDateTime surveyDate;

    public static SurveyAboutDrugDTO toDTO(SurveyAboutDrugEntity surveyAboutDrugEntity) {
        ModelMapper modelMapper = Util.getInstance().getMapper();
        modelMapper.addConverter(new AbstractConverter<UsedDrugByUserEntity, SurveyDTO>() {
            @Override
            protected SurveyDTO convert(UsedDrugByUserEntity usedDrugByUserEntity) {
                return SurveyDTO.toDTO(usedDrugByUserEntity);
            }
        });
        modelMapper.addConverter(new AbstractConverter<SiderMeddraFreqEntity, SiderMeddraFreqDTO>() {
            @Override
            protected SiderMeddraFreqDTO convert(SiderMeddraFreqEntity siderMeddraFreqEntity) {
                return SiderMeddraFreqDTO.toDTO(siderMeddraFreqEntity);
            }
        });
        return modelMapper.map(surveyAboutDrugEntity, SurveyAboutDrugDTO.class);
    }
}
