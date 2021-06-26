package mdar.com.drug.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicineMapperDTO {
    private int id;
    private String stitchIdFlat;
    private int atcCode;
}
