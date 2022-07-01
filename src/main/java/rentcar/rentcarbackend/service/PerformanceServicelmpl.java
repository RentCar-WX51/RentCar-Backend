package rentcar.rentcarbackend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rentcar.rentcarbackend.domain.model.entity.Performance;
import rentcar.rentcarbackend.domain.persistence.PerformanceRepository;
import rentcar.rentcarbackend.domain.service.PerformanceService;

import rentcar.rentcarbackend.shared.exception.ValidationException;
import rentcar.rentcarbackend.shared.exception.NotFoundException;

import javax.validation.ConstraintViolation;
import javax.xml.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class PerformanceServicelmpl implements PerformanceService {

    private static final String ENTITY = "Performance";
    private final PerformanceRepository performanceRepository;
    private final Validator validator;

    public PerformanceServicelmpl(PerformanceRepository performanceRepository, Validator validator){
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
    public Performance getById(Long performanceId) {
        return performanceRepository.findById(performanceId).orElseThrow(()->new NotFoundException(ENTITY, Math.toIntExact(performanceId)));
    }

    @Override
    public Performance create(Long performanceId,Performance performance) {
        Set<ConstraintViolation<Performance>> violations = validator.validate(performance);
        if(!violations.isEmpty())
            throw new ValidationException(ENTITY, violations);

        Performance performanceWithName = performanceRepository.findByName(performance.getName());
        if(performanceWithName != null)
            throw new ValidationException(ENTITY, "A performance with the same name already exists. ");
        return performanceRepository.save(performance);
    }

    @Override
    public Performance update(Long id, Performance request) {
        Set<ConstraintViolation<Performance>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw new ValidationException(ENTITY, violations);
        Performance performanceWithName = performanceRepository.findByName(request.getName());
        if(performanceWithName != null && !performanceWithName.getId().equals(id))
            throw new ValidationException(ENTITY,
                    "A performance with the same name already exists. ");
        return performanceRepository.findById(id).map(performance -> performanceRepository.save(performance.withName(request.getName())
                .withVehicleName(request.getVehicleName()).withSecurityVehicle(request.getSecurityVehicle()).withFuelVehicle(request.getFuelVehicle())
                .withParMotorVehicle(request.getParMotorVehicle()).withAccelerationVehicle(request.getAccelerationVehicle()))).orElseThrow(
                        ()-> new NotFoundException(ENTITY, Math.toIntExact(id)));
    }
    @Override
    public ResponseEntity<?> delete(Long performanceId) {
        return performanceRepository.findById(performanceId).map(performance -> {
            performanceRepository.delete(performance);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new NotFoundException(ENTITY, Math.toIntExact(performanceId)));
    }
}
