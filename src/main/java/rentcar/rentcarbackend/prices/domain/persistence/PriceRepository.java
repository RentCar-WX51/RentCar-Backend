package rentcar.rentcarbackend.prices.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rentcar.rentcarbackend.prices.domain.model.entity.Price;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {
    @Query(value = "SELECT * from prices where name like '%:name%'", nativeQuery = true)
    List<Price> fetchByName(@Param("name") String name);
}
