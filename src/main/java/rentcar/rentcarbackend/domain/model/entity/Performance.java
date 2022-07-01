package rentcar.rentcarbackend.domain.model.entity;

import lombok.*;
import org.hibernate.annotations.Type;
import shared.model.AuditModel;

import javax.persistence.*;
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
@Table(name="performances")
public class Performance extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

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
