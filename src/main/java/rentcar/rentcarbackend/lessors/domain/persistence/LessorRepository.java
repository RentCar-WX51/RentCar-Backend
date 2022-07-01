package rentcar.rentcarbackend.lessors.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rentcar.rentcarbackend.lessors.domain.model.entity.Lessor;

import java.util.List;

@Repository
public interface LessorRepository extends JpaRepository<Lessor, Integer> {
    @Query(value = "SELECT * from lessors where email like '%:email%'", nativeQuery = true)
    List<Lessor> fetchByEmail(@Param("email") String email);
}
