package rentcar.rentcarbackend.performances.api;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rentcar.rentcarbackend.performances.domain.model.entity.Performance;
import rentcar.rentcarbackend.performances.shared.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@SecurityRequirement(name = "rentcar")
@RestController
@RequestMapping("/api/v1/performances")
@AllArgsConstructor
public class PerformanceController {

    private final rentcar.rentcarbackend.performances.domain.service.PerformanceService performanceService;

    @GetMapping
    public List<Performance> getAll() {
        List<Performance> performances = performanceService.getAll();
        performances.forEach(System.out::println);
        return performances;
    }

    @GetMapping("{id}") //  /performances/{id}
    public Performance getById(@PathVariable("id") Integer id) {
        if (!performanceService.existsById(id)) {
            throw new NotFoundException("Performance", id);
        } else {
            Optional<Performance> optional = performanceService.getById(id);
            return optional.get();
        }
    }
    @PutMapping("{id}")
    public Performance updateById(@PathVariable("id") Integer id,
                              @RequestBody Performance performance) {
        if (!performanceService.existsById(id)) {
            throw new NotFoundException("Performance", id);
        } else
        {
            return performanceService.update(performance);
        }
    }

    @PostMapping
    public ResponseEntity<?> createPerformance(@RequestBody Performance performance) {
        Performance performanceResponse = performanceService.create(performance);
        return new ResponseEntity<>(performanceResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")

    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if (!performanceService.existsById(id)) {
            throw new NotFoundException("Performance", id);
        } else
        {
            performanceService.deleteById(id);
            //return new ResponseEntity<>(HttpStatus.ACCEPTED);
            return ResponseEntity.accepted().build();   // Lambda
        }
    }
}
