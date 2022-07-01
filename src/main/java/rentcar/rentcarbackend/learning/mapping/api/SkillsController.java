package rentcar.rentcarbackend.learning.mapping.api;


import rentcar.rentcarbackend.learning.domain.service.SkillService;
import rentcar.rentcarbackend.learning.mapping.SkillMapper;
import rentcar.rentcarbackend.learning.resource.CreateSkillResource;
import rentcar.rentcarbackend.learning.resource.SkillResource;
import rentcar.rentcarbackend.learning.resource.UpdateSkillResource;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "rentcar")
@RestController
@RequestMapping("/api/v1/skills")
@Tag(name = "Skills", description = "Create, read, update and delete skills")
public class SkillsController {

    private final SkillService skillService;

    private final SkillMapper mapper;


    public SkillsController(SkillService skillService, SkillMapper mapper) {
        this.skillService = skillService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<SkillResource> getAllSkills(Pageable pageable) {
        return mapper.modelListPage(skillService.getAll(), pageable);
    }

    @GetMapping("{skillId}")
    public SkillResource getSkillById(@PathVariable Long skillId) {
        return mapper.toResource(skillService.getById(skillId));
    }

    @PreAuthorize("hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    @PostMapping
    public SkillResource createSkill(@RequestBody CreateSkillResource resource) {
        return mapper.toResource(skillService.create(mapper.toModel(resource)));
    }

    @PreAuthorize("hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    @PutMapping("{skillId}")
    public SkillResource updateSkill(@PathVariable Long skillId, @RequestBody UpdateSkillResource resource) {
        return mapper.toResource(skillService.update(skillId, mapper.toModel(resource)));
    }

    @PreAuthorize("hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    @DeleteMapping("{skillId}")
    public ResponseEntity<?> deleteSkill(@PathVariable Long skillId) {
        return skillService.delete(skillId);
    }

}
