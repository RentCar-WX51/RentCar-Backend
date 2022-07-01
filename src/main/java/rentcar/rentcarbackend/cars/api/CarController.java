package rentcar.rentcarbackend.cars.api;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rentcar.rentcarbackend.cars.domain.model.entity.Car;
import rentcar.rentcarbackend.cars.shared.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@SecurityRequirement(name = "rentcar")
@RestController
@RequestMapping("/api/v1/cars")
@AllArgsConstructor
public class CarController {

    private final rentcar.rentcarbackend.cars.domain.service.CarService carService;

    @GetMapping
    public List<Car> getAll() {
        List<Car> cars = carService.getAll();
        cars.forEach(System.out::println);
        return cars;
    }

    @GetMapping("{id}") //  /cars/{id}
    public Car getById(@PathVariable("id") Integer id) {
        if (!carService.existsById(id)) {
            throw new NotFoundException("Car", id);
        } else {
            Optional<Car> optional = carService.getById(id);
            return optional.get();
        }
    }
    @PutMapping("{id}")
    public Car updateById(@PathVariable("id") Integer id,
                              @RequestBody Car car) {
        if (!carService.existsById(id)) {
            throw new NotFoundException("Car", id);
        } else
        {
            return carService.update(car);
        }
    }

    @PostMapping
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        Car carResponse = carService.create(car);
        return new ResponseEntity<>(carResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")

    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if (!carService.existsById(id)) {
            throw new NotFoundException("Car", id);
        } else
        {
            carService.deleteById(id);
            //return new ResponseEntity<>(HttpStatus.ACCEPTED);
            return ResponseEntity.accepted().build();   // Lambda
        }
    }
}
