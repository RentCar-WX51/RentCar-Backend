package rentcar.rentcarbackend.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "lessors")
@Data
public class Lessor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 40, min = 2)
    @NotNull
    @NotBlank
    @Column(name = "first_name", length = 30, nullable = false)
    private String fullname;

    @Min(value = 18)
    @Max(value = 60)
    @NotNull
    @Column(name = "age", nullable = false, columnDefinition = "SMALLINT")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @OneToMany
    private List<Car> cars;

}
