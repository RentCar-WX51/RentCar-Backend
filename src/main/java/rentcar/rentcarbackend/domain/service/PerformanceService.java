package rentcar.rentcarbackend.domain.service;

import org.springframework.data.domain.Pageable;
import rentcar.rentcarbackend.domain.model.entity.Performance;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PerformanceService {
    List<Performance> getAll();
    Page<Performance> getAll(Pageable pageable);
    Performance getById(Long performanceId);
    Performance create(Performance performance);
    Performance update(Long id, Performance performance);
    ResponseEntity<?> delete(Long performanceId);
}
