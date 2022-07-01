package rentcar.rentcarbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import rentcar.rentcarbackend.domain.model.entity.Lessor;
import rentcar.rentcarbackend.domain.persistence.LessorRepository;
import rentcar.rentcarbackend.domain.service.LessorService;
import org.springframework.stereotype.Service;
import rentcar.rentcarbackend.shared.exception.NotFoundException;

import javax.validation.ConstraintViolation;
import java.util.Set;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;

@Service
public class LessorServiceImpl implements LessorService {
    private static final String ENTITY = "Lessor";

    @Autowired
    private LessorRepository lessorRepository;

    @Autowired
    private Validator validator;

    @Override
    public Lessor create(Lessor lessorE) {
        Set<ConstraintViolation<Lessor>> violations = validator.validate(lessorE);

        if (!violations.isEmpty())
            throw new ValidationException(ENTITY, (Throwable) violations);
        return lessorRepository.save(lessorE);
    }

    @Override
    public Lessor update(Integer id, Lessor lessorE) {
        Set<ConstraintViolation<Lessor>> violations = validator.validate(lessorE);
        if (!violations.isEmpty())
            throw new ValidationException(ENTITY, (Throwable) violations);

        return lessorRepository.findById(id).map( lessor ->
                lessorRepository.save(
                        lessor.withFullname(lessorE.getFullname())
                                .withAge(lessorE.getAge()))
                                .withEmail(lessorE.getEmail())
                                .withAddress(lessorE.getAddress())
        ).orElseThrow(() -> new NotFoundException(ENTITY, id));
    }

    @Override
    public List<Lessor> getAll() { return lessorRepository.findAll(); }

    @Override
    public Optional<Lessor> getById(Integer id) {
        return Optional.ofNullable(lessorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ENTITY, id)));
    }

    @Override
    public ResponseEntity<?> deleteById(Integer id) {
        return lessorRepository.findById(id).map(lessor -> {
            lessorRepository.delete(lessor);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException(ENTITY, id));
    }

    @Override
    public boolean existsById(Integer id) { return lessorRepository.existsById(id); }
}
