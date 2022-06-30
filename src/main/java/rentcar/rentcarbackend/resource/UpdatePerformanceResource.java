package rentcar.rentcarbackend.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdatePerformanceResource {
    private Long Id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String vehicleName;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String securityVehicle;

    @NotNull
    @NotBlank
    @Size(max = 15)
    private String fuelVehicle;

    @NotNull
    @NotBlank
    @Size(max = 10)
    private String parMotorVehicle;

    @NotNull
    @NotBlank
    @Size(max = 10)
    private String accelerationVehicle;
}
