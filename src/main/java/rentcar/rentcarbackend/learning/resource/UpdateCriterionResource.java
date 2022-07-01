package rentcar.rentcarbackend.learning.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateCriterionResource {
    @NotNull
    @NotBlank
    private String name;
}
