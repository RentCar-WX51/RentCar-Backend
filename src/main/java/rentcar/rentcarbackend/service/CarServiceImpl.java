package rentcar.rentcarbackend.service;

import org.springframework.stereotype.Service;
import rentcar.rentcarbackend.domain.model.entity.Car;
import rentcar.rentcarbackend.domain.persistence.CarRepository;
import rentcar.rentcarbackend.domain.service.CarService;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {


    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getById(Integer id) {
        return carRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        carRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return carRepository.existsById(id);
    }
}
