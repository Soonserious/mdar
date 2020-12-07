package mdar.com.doctor.Entity;


import lombok.*;
import mdar.com.doctor.dto.ClinicDTO;
import mdar.com.user.dto.UserDTO;
import mdar.com.user.entity.UserEntity;
import mdar.com.util.LocalDateTimeAttributeConverter;
import mdar.com.util.Util;
import org.hibernate.annotations.CreationTimestamp;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clinic")
@Entity
public class ClinicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name="doctor_id")
    private UserEntity doctor;

    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name="patient_id")
    private UserEntity patient;

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @CreationTimestamp
    @Column(name = "clinic_date")
    private LocalDateTime clinicDate;

    public static ClinicEntity toEntity(ClinicDTO clinicDTO) {
        ModelMapper modelMapper = Util.getInstance().getMapper();
        modelMapper.addMappings(new ClinicEntityMapper());
        ClinicEntity clinicEntity = modelMapper.map(clinicDTO,ClinicEntity.class);
        return clinicEntity;
    }
    private static class ClinicEntityMapper extends PropertyMap<ClinicDTO, ClinicEntity>{

        @Override
        protected void configure() {
            Converter<UserDTO, UserEntity> converter = new AbstractConverter<UserDTO, UserEntity>() {
                @Override
                protected UserEntity convert(UserDTO userDTO) {
                    return UserEntity.toEntity(userDTO);
                }
            };
            map(source.getId(), destination.id);
            using(converter).map(source.getDoctor(), destination.doctor);
            using(converter).map(source.getPatient(), destination.patient);
            map(source.getClinicDate(), destination.clinicDate);
        }
    }
}
