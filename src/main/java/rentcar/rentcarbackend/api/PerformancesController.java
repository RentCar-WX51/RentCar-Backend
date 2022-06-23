package rentcar.rentcarbackend.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import rentcar.rentcarbackend.domain.service.PerformanceService;

@RestController
@Tag(name="Performances")
@RequestMapping("api/v1/performances")
public final class PerformancesController {
    private final PerformanceService performanceService;

}
