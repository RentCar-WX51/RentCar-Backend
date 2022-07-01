package rentcar.rentcarbackend.cars.service;

import org.springframework.stereotype.Service;
import rentcar.rentcarbackend.cars.domain.model.entity.Car;

import java.util.List;
import java.util.Optional;

//@AllArgsConstructor
@Service
public class CarServiceImpl implements rentcar.rentcarbackend.cars.domain.service.CarService {

    //@Autowired
    private final rentcar.rentcarbackend.cars.domain.persistence.CarRepository carRepository;

    public CarServiceImpl(rentcar.rentcarbackend.cars.domain.persistence.CarRepository carRepository) {
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
