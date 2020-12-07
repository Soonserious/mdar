package mdar.com.doctor.dto;


import lombok.*;
import mdar.com.doctor.Entity.ClinicEntity;
import mdar.com.doctor.Entity.PrescriptionEntity;
import mdar.com.util.Util;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDTO {
    private int id;
    private ClinicDTO clinicDTO;
    private LocalDateTime prescriptionTime;


    public static PrescriptionDTO toDTO(Page<PrescriptionEntity> prescriptionEntities) {
        ModelMapper modelMapper = Util.getInstance().getMapper();
        modelMapper.addMappings(new PrescriptionDTOMapper());
        return modelMapper.map(prescriptionEntities,PrescriptionDTO.class);
    }

    private static class PrescriptionDTOMapper extends PropertyMap<PrescriptionEntity, PrescriptionDTO>{

        @Override
        protected void configure() {
            Converter<ClinicEntity, ClinicDTO> converter = new AbstractConverter<ClinicEntity, ClinicDTO>() {
                @Override
                protected ClinicDTO convert(ClinicEntity clinicEntity) {
                    return ClinicDTO.toDTO(clinicEntity);
                }
            };
            using(converter).map(source.getClinicEntity(),destination.clinicDTO);
            map(source.getId(),destination.id);
            map(source.getPrescriptionTime(),destination.prescriptionTime);
        }
    }
}
