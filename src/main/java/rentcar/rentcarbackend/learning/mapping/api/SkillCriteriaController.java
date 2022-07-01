package rentcar.rentcarbackend.learning.mapping.api;

import rentcar.rentcarbackend.learning.domain.service.CriterionService;
import rentcar.rentcarbackend.learning.mapping.CriterionMapper;
import rentcar.rentcarbackend.learning.resource.CreateCriterionResource;
import rentcar.rentcarbackend.learning.resource.CriterionResource;
import rentcar.rentcarbackend.learning.resource.UpdateCriterionResource;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "rentcar")
@RestController
@RequestMapping("/api/v1/skills/{skillId}/criteria")
@Tag(name = "Skills", description = "Create, read, update and delete skills")
public class SkillCriteriaController {

    private final CriterionService criterionService;

    private final CriterionMapper mapper;

    public SkillCriteriaController(CriterionService criterionService, CriterionMapper mapper) {
        this.criterionService = criterionService;
        this.mapper = mapper;
    }

    @PreAuthorize("hasRole('USER') or hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    @GetMapping
    public Page<CriterionResource> getAllCriteriaBySkillId(@PathVariable Long skillId, Pageable pageable) {
        return mapper.modelListPage(criterionService.getAllBySkillId(skillId), pageable);
    }

    @PreAuthorize("hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    @PostMapping
    public CriterionResource createCriterion(@PathVariable Long skillId,
                                             @RequestBody CreateCriterionResource resource) {

        return mapper.toResource(criterionService.create(skillId, mapper.toModel(resource)));
    }

    @PreAuthorize("hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    @PutMapping("{criterionId}")
    public CriterionResource updateCriterion(@PathVariable Long skillId,
                                             @PathVariable Long criterionId,
                                             @RequestBody UpdateCriterionResource resource) {
        return mapper.toResource(criterionService.update(skillId, criterionId, mapper.toModel(resource)));
    }

    @PreAuthorize("hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    @DeleteMapping("{criterionId}")
    public ResponseEntity<?> deleteCriterion(@PathVariable Long skillId,
                                             @PathVariable Long criterionId) {
        return criterionService.delete(skillId, criterionId);
    }

}
