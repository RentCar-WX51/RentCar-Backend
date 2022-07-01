package rentcar.rentcarbackend.performances.domain.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "performances")
@Data
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 60, min = 4)
    @Column(name = "name")
    private String name;

    @Length(max = 60, min = 4)
    @Column(name = "vehicleName")
    private String vehicleName;

    @Length(max = 60, min = 4)
    @Column(name = "securityVehicle")
    private String securityVehicle;

    @Length(max = 60, min = 4)
    @Column(name = "fuelVehicle")
    private String fuelVehicle;

    @Length(max = 60, min = 4)
    @Column(name = "parMotorVehicle")
    private String parMotorVehicle;

    @Length(max = 60, min = 4)
    @Column(name = "accelerationVehicle")
    private String accelerationVehicle;
}
