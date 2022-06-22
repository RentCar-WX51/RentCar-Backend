package rentcar.rentcarbackend.domain.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.transform.Source;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;

    @Size(max = 60)
    private String vehicleName;

    @Size(max = 60)
    private String securityVehicle;

    @Size(max = 15)
    private String fuelVehicle;

    @Size(max = 10)
    private String parMotorVehicle;

    @Size(max = 10)
    private String accelerationVehicle;


    //Relationships

}
