package rentcar.rentcarbackend.prices.domain.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "prices")
@Data
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 60, min = 4)
    @Column(name = "titulo",length = 20)
    private String titulo;

    @Length(max = 60, min = 4)
    @Column(name = "descripcion",length = 20)
    private String descripcion;

    @Min(value = 0)
    @Max(value = 60000)
    @NotNull
    @Column(name = "valor", nullable = false, columnDefinition = "FLOAT")
    private Float valor;

    @Length(max = 4, min = 1)
    @Column(name = "moneda",length = 20)
    private String moneda;

    @Length(max = 60, min = 4)
    @Column(name = "tipoTarifa",length = 20)
    private String tipoTarifa;

    @Length(max = 10, min = 3)
    @Column(name = "vigencia",length = 20)
    private String vigencia;
}
