package rentcar.rentcarbackend.domain.service;

import org.springframework.http.ResponseEntity;
import rentcar.rentcarbackend.domain.model.entity.Lessor;

import java.util.List;
import java.util.Optional;

public interface LessorService {
    Lessor create(Lessor lessor);
    Lessor update(Integer id, Lessor lessorE);

    List<Lessor> getAll();
    Optional<Lessor> getById(Integer id);
    ResponseEntity<?> deleteById(Integer id);
    boolean existsById(Integer id);
}
