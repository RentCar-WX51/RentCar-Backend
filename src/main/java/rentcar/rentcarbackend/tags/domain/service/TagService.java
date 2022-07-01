package rentcar.rentcarbackend.tags.domain.service;

import rentcar.rentcarbackend.tags.domain.model.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    // CRUD
    Tag create(Tag tag);
    Tag update(Tag tag);
    List<Tag> getAll();
    Optional<Tag> getById(Integer id);
    void deleteById(Integer id);
    boolean existsById(Integer id);
}
