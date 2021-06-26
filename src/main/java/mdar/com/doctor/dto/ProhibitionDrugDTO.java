package mdar.com.doctor.dto;


import lombok.*;
import mdar.com.doctor.Entity.ClinicEntity;
import mdar.com.doctor.Entity.PrescriptionEntity;
import mdar.com.doctor.Entity.ProhibitionDrugEntity;
import mdar.com.util.Util;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProhibitionDrugDTO {
    int id;
    PrescriptionDTO prescription;
    DrugDTO drug;

    public static ProhibitionDrugDTO toDTO(ProhibitionDrugEntity prohibitionDrugEntity) {
        ModelMapper modelMapper = Util.getInstance().getMapper();
        modelMapper.addConverter(new AbstractConverter<PrescriptionEntity, PrescriptionDTO>() {
            @Override
            protected PrescriptionDTO convert(PrescriptionEntity prescriptionEntity) {
                return PrescriptionDTO.toDTO(prescriptionEntity);
            }
        });
        return modelMapper.map(prohibitionDrugEntity, ProhibitionDrugDTO.class);
    }
}
