package rentcar.rentcarbackend.learning.mapping.api;

import rentcar.rentcarbackend.learning.domain.service.StudentService;
import rentcar.rentcarbackend.learning.mapping.StudentMapper;
import rentcar.rentcarbackend.learning.resource.CreateStudentResource;
import rentcar.rentcarbackend.learning.resource.StudentResource;
import rentcar.rentcarbackend.learning.resource.UpdateStudentResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "acme")
@RestController
@RequestMapping(value = "api/v1/students", produces = "application/json")
@Tag(name = "Students", description = "Create, read, update and delete students")
public class StudentsController {
    private final StudentService studentService;

    private final StudentMapper mapper;

    public StudentsController(StudentService studentService, StudentMapper mapper) {
        this.studentService = studentService;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Get all students")
    @PreAuthorize("hasRole('USER') or hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    public Page<StudentResource> getAllStudents(@ParameterObject Pageable pageable) {
        return mapper.modelListPage(studentService.getAll(), pageable);
    }

    @GetMapping("{studentId}")
    @PreAuthorize("hasRole('USER') or hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    public StudentResource getStudentById(@PathVariable Long studentId) {
        return mapper.toResource(studentService.getById(studentId));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create Student", responses = {
      @ApiResponse(description = "Student successfully created", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentResource.class)))
    })
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource) {
        return new ResponseEntity<>(mapper.toResource(studentService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{studentId}")
    @PreAuthorize("hasRole('ADMIN')")
    public StudentResource updateStudent(@PathVariable Long studentId, @RequestBody UpdateStudentResource resource) {
        return mapper.toResource(studentService.update(studentId, mapper.toModel(resource)));
    }

    @DeleteMapping("{studentId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteStudent(@PathVariable Long studentId) {
        return studentService.delete(studentId);
    }


}