package rentcar.rentcarbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rentcar.rentcarbackend.domain.model.entity.Performance;
import rentcar.rentcarbackend.domain.service.persistence.PerformanceRepository;
import rentcar.rentcarbackend.domain.service.PerformanceService;
import rentcar.rentcarbackend.shared.exception.ResourceNotFoundException;
import rentcar.rentcarbackend.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private static final String ENTITY = "Performance";
    @Autowired
    private final PerformanceRepository performanceRepository;
    @Autowired
    private final Validator validator;

    public PerformanceServiceImpl(PerformanceRepository performanceRepository, Validator validator){
        this.performanceRepository = performanceRepository;
        this.validator=validator;
    }
    @Override
    public List<Performance> getAll() {
        return performanceRepository.findAll();
    }

    @Override
    public Page<Performance> getAll(Pageable pageable) {
        return performanceRepository.findAll(pageable);
    }

    @Override
    public Performance getById(Integer performanceId) {
        return  performanceRepository.findById(performanceId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,performanceId));
    }

    @Override
    public Performance create(Performance performance) {
        Set<ConstraintViolation<Performance>> violations = validator.validate(performance);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        Optional<Performance> performanceWithName = performanceRepository.findByName(performance.getName());
        if(performanceWithName.isPresent())
            throw new ResourceValidationException(ENTITY, "A performance with the same name already exists.");
        return performanceRepository.save(performance);
    }
    
    @Override
    public Performance update(Integer id, Performance performance) {
        Set<ConstraintViolation<Performance>> violations = validator.validate(performance);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        Optional<Performance> performanceWithName = performanceRepository.findByName(performance.getName());
        if(performanceWithName.isPresent() && !performanceWithName.get().getId().equals(id))
            throw new ResourceValidationException(ENTITY, "A performance with the same name already exists.");
        return performanceRepository.findById(id).map(existingPerformance->performanceRepository.save(existingPerformance.withName(performance.getName())))
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,id));
    }
    @Override
    public ResponseEntity<?> delete(Integer performanceId) {
        return performanceRepository.findById(performanceId).map(performance -> {
            performanceRepository.delete(performance);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY,performanceId));
    }
}
