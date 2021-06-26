package mdar.com.patient.dto;
import lombok.*;
import mdar.com.drug.Entity.DrugEntity;
import mdar.com.drug.dto.DrugDTO;
import mdar.com.patient.entity.UsedDrugByUserEntity;
import mdar.com.user.dto.UserDTO;
import mdar.com.user.entity.UserEntity;
import mdar.com.util.Util;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsedDrugByUserDTO {
    private int id;
    private UserDTO user;
    private DrugDTO drug;
    private LocalDateTime usedDate;

    public static UsedDrugByUserDTO toDTO(UsedDrugByUserEntity usedDrugByUserEntity) {
        ModelMapper modelMapper = Util.getInstance().getMapper();
        modelMapper.addConverter(new AbstractConverter<UserEntity, UserDTO>() {
            @Override
            protected UserDTO convert(UserEntity userEntity) {
                return UserDTO.toDTO(userEntity);
            }
        });
        modelMapper.addConverter(new AbstractConverter<DrugEntity, DrugDTO>() {
            @Override
            protected DrugDTO convert(DrugEntity drugEntity) {
                return DrugDTO.toDTO(drugEntity);
            }
        });
        return modelMapper.map(usedDrugByUserEntity, UsedDrugByUserDTO.class);
    }
}
