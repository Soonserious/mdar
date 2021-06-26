package mdar.com.drug.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ATCMaterialDTO {
    private int id;
    private MaterialDTO material;
    private ATCCodeDTO atcCode;

}
