package rentcar.rentcarbackend.domain.model.entity;

import lombok.*;
import org.hibernate.annotations.Type;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Type(type = "org.hibernate.type.TextType")
    private String name;

    @Size(max = 60)
    @Type(type = "org.hibernate.type.TextType")
    private String vehicleName;

    @Size(max = 60)
    @Type(type = "org.hibernate.type.TextType")
    private String securityVehicle;

    @Size(max = 15)
    @Type(type = "org.hibernate.type.TextType")
    private String fuelVehicle;

    @Size(max = 10)
    @Type(type = "org.hibernate.type.TextType")
    private String parMotorVehicle;

    @Size(max = 10)
    @Type(type = "org.hibernate.type.TextType")
    private String accelerationVehicle;


    //Relationships


}
