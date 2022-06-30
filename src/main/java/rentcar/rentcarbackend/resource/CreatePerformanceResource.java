package rentcar.rentcarbackend.resource;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePerformanceResource {
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

}
