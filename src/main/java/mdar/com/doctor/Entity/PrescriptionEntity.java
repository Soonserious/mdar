package mdar.com.doctor.Entity;

import lombok.*;
import mdar.com.doctor.dto.ClinicDTO;
import mdar.com.util.LocalDateTimeAttributeConverter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="prescription")
public class PrescriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = ClinicEntity.class)
    @JoinColumn(name = "clinic_id")
    private ClinicEntity clinicEntity;

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @CreationTimestamp
    @Column(name = "prescription_time")
    private LocalDateTime prescriptionTime;
}
