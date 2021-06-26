package mdar.com.doctor.Entity;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name="prohibition_drug")
public class ProhibitionDrugEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = PrescriptionEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "prescription_id")
    private PrescriptionEntity prescription;

    @ManyToOne(targetEntity = DrugEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "drug_id")
    private DrugEntity drug;
}
