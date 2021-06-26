package mdar.com.drug.dto;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pharmacuilcal_excipients")
public class ExcipientsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "excipients_name")
    private String excipientsName;
}
