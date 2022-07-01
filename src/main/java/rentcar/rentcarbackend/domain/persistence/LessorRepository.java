package rentcar.rentcarbackend.domain.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rentcar.rentcarbackend.domain.model.entity.Lessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessorRepository extends JpaRepository<Lessor, Integer> {
    List<Lessor> findByCarId(Integer carId);
    Page<Lessor> findByCarId(Integer carId, Pageable pageable);
    Optional<Lessor> findByIdAndCarId(Integer id, Integer carId);
}
