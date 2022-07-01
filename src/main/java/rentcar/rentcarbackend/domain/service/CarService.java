package rentcar.rentcarbackend.domain.service;

import rentcar.rentcarbackend.domain.model.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    Car create(Car car);

    Car update(Car car);

    List<Car> getAll();

    Optional<Car> getById(Integer id);

    void deleteById(Integer id);

    boolean existsById(Integer id);
}
