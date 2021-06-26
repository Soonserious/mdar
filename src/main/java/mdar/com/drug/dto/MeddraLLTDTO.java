package mdar.com.drug.dto;


import lombok.*;
import mdar.com.drug.Entity.AdrEntity;
import mdar.com.drug.Entity.DrugEntity;
import mdar.com.util.Util;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdrDTO {
    private int id;
    private String meddraName;
    public static AdrDTO toDTO(AdrEntity adrEntity) {
        ModelMapper modelMapper = Util.getInstance().getMapper();
        modelMapper.addConverter(new AbstractConverter<DrugEntity, DrugDTO>() {
            @Override
            protected DrugDTO convert(DrugEntity drugEntity) {
                return DrugDTO.toDTO(drugEntity);
            }
        });
        return modelMapper.map(adrEntity,AdrDTO.class);
    }
}
