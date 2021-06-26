package mdar.com.drug.Entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="atc_material_mapping")
@Entity
public class ATCMaterialMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "")
}
