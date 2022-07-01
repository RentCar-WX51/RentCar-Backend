package rentcar.rentcarbackend.performances.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rentcar.rentcarbackend.performances.domain.model.entity.Performance;

import java.util.List;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Integer> {
    @Query(value = "SELECT * from performances where name like '%:name%'", nativeQuery = true)
    List<Performance> fetchByName(@Param("name") String name);
}
