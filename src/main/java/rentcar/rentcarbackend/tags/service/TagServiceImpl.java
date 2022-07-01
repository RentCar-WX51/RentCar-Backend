package rentcar.rentcarbackend.tags.service;

import org.springframework.stereotype.Service;
import rentcar.rentcarbackend.tags.domain.model.entity.Tag;

import java.util.List;
import java.util.Optional;

//@AllArgsConstructor
@Service
public class TagServiceImpl implements rentcar.rentcarbackend.tags.domain.service.TagService {

    //@Autowired
    private final rentcar.rentcarbackend.tags.domain.persistence.TagRepository tagRepository;

    public TagServiceImpl(rentcar.rentcarbackend.tags.domain.persistence.TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag create(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag update(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> getById(Integer id) {
        return tagRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        tagRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return tagRepository.existsById(id);
    }

}
