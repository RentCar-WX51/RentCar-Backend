package rentcar.rentcarbackend.cars.domain.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "cars")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 20, min = 4)
    @Column(name = "model",length = 20)
    private String model;

    @Column(name = "placa",length = 20)
    private String placa;


    @Column(name = "age", columnDefinition = "SMALLINT")
    private Integer age;
}
