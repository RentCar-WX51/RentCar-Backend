package rentcar.rentcarbackend.security.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "tenants")
@Data
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 40, min = 2)
    @NotNull
    @NotBlank
    @Column(name = "last_name", length = 40, nullable = false)
    private String lastName;

    @Column(name = "first_name", length = 40, nullable = false)
    private String firstName;

    @Column(name = "address", length = 40, nullable = false)
    private String address;

    @Column(name = "city", length = 40, nullable = false)
    private String city;

    @Column(name = "email", length = 40, nullable = false)
    private String email;

    @Column(name = "cellphone", length = 9, nullable = false)
    private String cellphone;

    @Column(name = "license", length = 9, nullable = false)
    private String license;

    @Column(name = "dni", length = 8, nullable = false)
    private String dni;

    @Column(name = "birth_day")
    @Temporal(TemporalType.DATE)
    private Date birthday;


    @Min(value = 0)
    @Max(value = 120)
    @NotNull
    @Column(name = "age", nullable = false, columnDefinition = "SMALLINT")
    private Integer age;




}
