package rentcar.rentcarbackend.cars.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rentcar.rentcarbackend.cars.domain.model.entity.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByPlacaAndAge( String placa, Integer age);

    @Query(value = "SELECT c from Car c where c.model like '%:placa%'and c.age < :age")
    List<Car> fetchByPlacaAndAge(@Param("placa") String placa,
                                 @Param("age") Integer age);
}
