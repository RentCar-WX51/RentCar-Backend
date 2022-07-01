package rentcar.rentcarbackend.performances.service;

import org.springframework.stereotype.Service;
import rentcar.rentcarbackend.performances.domain.model.entity.Performance;

import java.util.List;
import java.util.Optional;

//@AllArgsConstructor
@Service
public class PerformanceServiceImpl implements rentcar.rentcarbackend.performances.domain.service.PerformanceService {

    //@Autowired
    private final rentcar.rentcarbackend.performances.domain.persistence.PerformanceRepository performanceRepository;

    public PerformanceServiceImpl(rentcar.rentcarbackend.performances.domain.persistence.PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }

    @Override
    public Performance create(Performance performance) {
        return performanceRepository.save(performance);
    }

    @Override
    public Performance update(Performance performance) {
        return performanceRepository.save(performance);
    }

    @Override
    public List<Performance> getAll() {
        return performanceRepository.findAll();
    }

    @Override
    public Optional<Performance> getById(Integer id) {
        return performanceRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        performanceRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return performanceRepository.existsById(id);
    }

}
