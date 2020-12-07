package mdar.com.user.entity;
import lombok.*;
import mdar.com.user.dto.UserDTO;
import mdar.com.user.entity.enumEntity.Hospital;
import mdar.com.user.entity.enumEntity.Sex;
import mdar.com.user.entity.enumEntity.converter.db.HospitalConverter;
import mdar.com.user.entity.enumEntity.converter.db.SexConverter;
import mdar.com.util.LocalDateTimeAttributeConverter;
import mdar.com.util.Util;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;
import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="user")
@Builder(builderMethodName = "builder")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="userID",length = 15, nullable = false)
    private String userID;

    @Column(name="password",length = 100, nullable = false)
    private String password;

    @Column(name ="phoneNumber", length=13, nullable = false)
    @Builder.Default private int phoneNumber = -1;

    @Column(name = "name" , length = 10, nullable = false)
    @Builder.Default private String name = "";

    @Column(name = "email",length = 20, nullable = false)
    @Builder.Default private String email ="";

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @CreationTimestamp
    @Column(name = "signDate")
    private LocalDateTime signinDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "lastLogin")
    private Date lastLogin;

    @Convert(converter = HospitalConverter.class)
    @Column(name = "hospital", columnDefinition = "int")
    @Builder.Default private Hospital hospital = Hospital.ChungBuk;

    @Convert(converter = SexConverter.class)
    @Column(name = "sex", columnDefinition = "int")
    @Builder.Default private Sex sex = Sex.Man;

    public static UserEntity toEntity(UserDTO userDTO){
        UserEntity userEntity = Util.getInstance().getMapper().map(userDTO,UserEntity.class);
        return userEntity;
    }
}
