package rentcar.rentcarbackend.lessors.service;

import org.springframework.stereotype.Service;
import rentcar.rentcarbackend.lessors.domain.model.entity.Lessor;

import java.util.List;
import java.util.Optional;

//@AllArgsConstructor
@Service
public class LessorServiceImpl implements rentcar.rentcarbackend.lessors.domain.service.LessorService {

    //@Autowired
    private final rentcar.rentcarbackend.lessors.domain.persistence.LessorRepository lessorRepository;

    public LessorServiceImpl(rentcar.rentcarbackend.lessors.domain.persistence.LessorRepository lessorRepository) {
        this.lessorRepository = lessorRepository;
    }

    @Override
    public Lessor create(Lessor lessor) {
        return lessorRepository.save(lessor);
    }

    @Override
    public Lessor update(Lessor lessor) {
        return lessorRepository.save(lessor);
    }

    @Override
    public List<Lessor> getAll() {
        return lessorRepository.findAll();
    }

    @Override
    public Optional<Lessor> getById(Integer id) {
        return lessorRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        lessorRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return lessorRepository.existsById(id);
    }

}
