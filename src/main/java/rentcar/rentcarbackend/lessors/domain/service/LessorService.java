package rentcar.rentcarbackend.lessors.domain.service;

import rentcar.rentcarbackend.lessors.domain.model.entity.Lessor;

import java.util.List;
import java.util.Optional;

public interface LessorService {
    // CRUD
    Lessor create(Lessor lessor);
    Lessor update(Lessor lessor);
    List<Lessor> getAll();
    Optional<Lessor> getById(Integer id);
    void deleteById(Integer id);
    boolean existsById(Integer id);
}
