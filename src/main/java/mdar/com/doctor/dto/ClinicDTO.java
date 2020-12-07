package mdar.com.doctor.dto;


import lombok.*;
import mdar.com.doctor.Entity.ClinicEntity;
import mdar.com.user.dto.UserDTO;
import mdar.com.user.entity.UserEntity;
import mdar.com.util.Util;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "builder")
public class ClinicDTO {
    private int id;
    private UserDTO doctor;
    private UserDTO patient;
    private LocalDateTime clinicDate;

    public static ClinicDTO toDTO(ClinicEntity clinicEntity) {
        ModelMapper modelMapper = Util.getInstance().getMapper();
        modelMapper.createTypeMap(clinicEntity, ClinicDTO.class);
        modelMapper.addMappings(new ClinicMapper());
        ClinicDTO clinicDTO = modelMapper.map(clinicEntity,ClinicDTO.class);
        return clinicDTO;
    }

    private static class ClinicMapper extends PropertyMap<ClinicEntity,ClinicDTO>{

        @Override
        protected void configure() {
            Converter<UserEntity, UserDTO> userConverter = new AbstractConverter<UserEntity, UserDTO>() {
                @Override
                protected UserDTO convert(UserEntity userEntity) {
                    return UserDTO.toDTO(userEntity);
                }
            };
            map(source.getId(), destination.id);
            using(userConverter).map(source.getDoctor(), destination.doctor);
            using(userConverter).map(source.getPatient(), destination.patient);
            map(source.getClinicDate(), destination.clinicDate);

        }
    }
}
