package rentcar.rentcarbackend.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rentcar.rentcarbackend.domain.model.entity.Car;
import rentcar.rentcarbackend.domain.service.CarService;
import rentcar.rentcarbackend.shared.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public List<Car> getAll(){
        List<Car> cars = carService.getAll();
        cars.forEach(System.out::println);
        return cars;
    }

    @GetMapping("{id}") //  /students/{id}
    public Car getById(@PathVariable("id") Integer id) {
        if (!carService.existsById(id)) {
            throw new NotFoundException("Car", id);
        } else {
            Optional<Car> optional = carService.getById(id);
            return optional.get();
        }
    }

    @PostMapping
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        // Faltan validaciones
        Car carResponse = carService.create(car);
        return new ResponseEntity<>(carResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")

    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if (!carService.existsById(id)) {
            throw new NotFoundException("Car", id);
        } else
        {   // Faltan las demas validaciones
            carService.deleteById(id);
            //return new ResponseEntity<>(HttpStatus.ACCEPTED);
            return ResponseEntity.accepted().build();   // Lambda
        }
    }
}
