package rentcar.rentcarbackend.lessors.api;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rentcar.rentcarbackend.lessors.domain.model.entity.Lessor;
import rentcar.rentcarbackend.lessors.shared.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@SecurityRequirement(name = "rentcar")
@RestController
@RequestMapping("/api/v1/lessors")
@AllArgsConstructor
public class LessorController {

    private final rentcar.rentcarbackend.lessors.domain.service.LessorService lessorService;

    @GetMapping
    public List<Lessor> getAll() {
        List<Lessor> lessors = lessorService.getAll();
        lessors.forEach(System.out::println);
        return lessors;
    }

    @GetMapping("{id}") //  /lessors/{id}
    public Lessor getById(@PathVariable("id") Integer id) {
        if (!lessorService.existsById(id)) {
            throw new NotFoundException("Lessor", id);
        } else {
            Optional<Lessor> optional = lessorService.getById(id);
            return optional.get();
        }
    }
    @PutMapping("{id}")
    public Lessor updateById(@PathVariable("id") Integer id,
                              @RequestBody Lessor lessor) {
        if (!lessorService.existsById(id)) {
            throw new NotFoundException("Lessor", id);
        } else
        {
            return lessorService.update(lessor);
        }
    }

    @PostMapping
    public ResponseEntity<?> createLessor(@RequestBody Lessor lessor) {
        Lessor lessorResponse = lessorService.create(lessor);
        return new ResponseEntity<>(lessorResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")

    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if (!lessorService.existsById(id)) {
            throw new NotFoundException("Lessor", id);
        } else
        {
            lessorService.deleteById(id);
            //return new ResponseEntity<>(HttpStatus.ACCEPTED);
            return ResponseEntity.accepted().build();   // Lambda
        }
    }
}
