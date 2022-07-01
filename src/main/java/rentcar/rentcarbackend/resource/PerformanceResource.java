package rentcar.rentcarbackend.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceResource {

    private Long Id;
    private String name;
    private String vehicleName;
    private String securityVehicle;
    private String fuelVehicle;
    private String parMotorVehicle;
    private String accelerationVehicle;

}
