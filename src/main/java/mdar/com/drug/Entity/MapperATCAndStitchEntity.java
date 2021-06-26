package mdar.com.drug.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="medicine_mapper")
@Entity
public class MedicineMapperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="stitch_id_flat")
    private String stitchIdFlat;

    @ManyToOne
    @JoinColumn(name = "atc_code_id")
    private ATCCodeEntity atcCodeId;
}
