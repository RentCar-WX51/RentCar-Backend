package rentcar.rentcarbackend.domain.service.persistence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentcar.rentcarbackend.domain.model.entity.Performance;
import java.util.List;
import java.util.Optional;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Integer> {
    List<Performance> findByPerformanceId(Integer performanceId);
    Page<Performance> findByPerformanceId(Integer performanceId, Pageable pageable);
    Optional<Performance> findByIdAndPerformanceId(Integer id, Integer performanceId);
    Optional<Performance> findByName(String name);
}
