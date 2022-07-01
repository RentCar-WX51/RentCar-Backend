package rentcar.rentcarbackend.learning.domain.persistence;

import rentcar.rentcarbackend.learning.domain.model.entity.Criterion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CriterionRepository extends JpaRepository<Criterion, Long> {
    List<Criterion> findBySkillId(Long skillId);
    Page<Criterion> findBySkillId(Long skillId, Pageable pageable);
    Optional<Criterion> findByIdAndSkillId(Long id, Long skillId);
}
