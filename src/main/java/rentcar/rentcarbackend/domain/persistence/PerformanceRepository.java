package rentcar.rentcarbackend.domain.persistence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import rentcar.rentcarbackend.domain.model.entity.Performance;
import java.util.List;
import java.util.Optional;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {
    Performance findByName(String name);
    List<Performance> findByPerformanceId(Long performanceId);
    Page<Performance> findByPerformanceId(Long performanceId, Pageable pageable);
    Optional<Performance> findByIdAndPerformanceId(Long id, Long performanceId);
}
