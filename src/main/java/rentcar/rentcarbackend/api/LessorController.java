package rentcar.rentcarbackend.api;

import rentcar.rentcarbackend.domain.model.entity.Lessor;
import rentcar.rentcarbackend.domain.service.LessorService;
import rentcar.rentcarbackend.shared.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lessors")
@AllArgsConstructor
public class LessorController {
    private final LessorService lessorService;

    @GetMapping
    public List<Lessor> getAll()
    {
        List<Lessor> lessors = lessorService.getAll();
        lessors.forEach(System.out::println);
        return lessors;
    }

    @GetMapping("{id}")
    public Lessor getById(@PathVariable("id") Integer id) {
        if (!lessorService.existsById(id))
            throw new NotFoundException("Lessor", id);
        else {
            Optional<Lessor> optional = lessorService.getById(id);
            return optional.get();
        }
    }

    @PutMapping("{id}")
    public Lessor updateById(@PathVariable("id") Integer id, @RequestBody Lessor lessor)
    {
        if (!lessorService.existsById(id))
                throw new NotFoundException("Lessor", id);
        else
        {
            return lessorService.update(lessor);
        }
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Lessor lessor)
    {
        Lessor lessorResponse = lessorService.create(lessor);
        return new ResponseEntity<>(lessorResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id)
    {
        if (!lessorService.existsById(id))
            throw new NotFoundException("Lessor", id);
        else
        {
            lessorService.deleteById(id);
            return ResponseEntity.accepted().build();
        }
    }


}
