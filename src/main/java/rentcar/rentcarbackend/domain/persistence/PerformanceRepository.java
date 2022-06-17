package rentcar.rentcarbackend.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import rentcar.rentcarbackend.domain.model.entity.Performance;
import java.util.List;
import java.util.Optional;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {
    List<Performance> findByLicensePlate(String licensePlate);
}
