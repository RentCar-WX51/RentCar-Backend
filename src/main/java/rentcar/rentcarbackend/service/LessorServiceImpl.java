package rentcar.rentcarbackend.service;

import com.rentcar.rencar.domain.model.entity.Lessor;
import com.rentcar.rencar.domain.persistence.LessorRepository;
import com.rentcar.rencar.domain.service.LessorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessorServiceImpl implements LessorService {
    private final LessorRepository lessorRepository;

    public LessorServiceImpl(LessorRepository lessorRepository) { this.lessorRepository = lessorRepository; }

    @Override
    public Lessor create(Lessor lessor) { return lessorRepository.save(lessor); }

    @Override
    public Lessor update(Lessor lessor) { return lessorRepository.save(lessor); }

    @Override
    public List<Lessor> getAll() { return lessorRepository.findAll(); }

    @Override
    public Optional<Lessor> getById(Integer id) { return lessorRepository.findById(id); }

    @Override
    public void deleteById(Integer id) { lessorRepository.deleteById(id); }

    @Override
    public boolean existsById(Integer id) { return lessorRepository.existsById(id); }
}
