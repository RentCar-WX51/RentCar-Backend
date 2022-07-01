package rentcar.rentcarbackend.learning.mapping.api;

import rentcar.rentcarbackend.learning.domain.service.CriterionService;
import rentcar.rentcarbackend.learning.mapping.CriterionMapper;
import rentcar.rentcarbackend.learning.resource.CriterionResource;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "rentcar")
@RestController
@RequestMapping("/api/v1/criteria")
@Tag(name = "Criteria", description = "Create, read, update and delete criteria")
public class CriteriaController {
    private final CriterionService criterionService;

    private final CriterionMapper mapper;

    public CriteriaController(CriterionService criterionService, CriterionMapper mapper) {
        this.criterionService = criterionService;
        this.mapper = mapper;
    }

    @PreAuthorize("hasRole('USER') or hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    @GetMapping
    public Page<CriterionResource> getAllCriteria(Pageable pageable) {
        return mapper.modelListPage(criterionService.getAll(), pageable);
    }
}
