package rentcar.rentcarbackend.performances.domain.service;

import rentcar.rentcarbackend.performances.domain.model.entity.Performance;

import java.util.List;
import java.util.Optional;

public interface PerformanceService {
    // CRUD
    Performance create(Performance performance);
    Performance update(Performance performance);
    List<Performance> getAll();
    Optional<Performance> getById(Integer id);
    void deleteById(Integer id);
    boolean existsById(Integer id);
}
