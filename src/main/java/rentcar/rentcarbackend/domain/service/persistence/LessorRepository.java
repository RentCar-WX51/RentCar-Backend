package rentcar.rentcarbackend.domain.service.persistence;

import rentcar.rentcarbackend.domain.model.entity.Lessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessorRepository extends JpaRepository<Lessor, Integer> {
    List<Lessor> findByLastNameAndAge(String lastName, Integer age);

    @Query(value = "SELECT * from lessors where last_name like '%:lastName' and age < :age", nativeQuery = true)
    List<Lessor> fetchByLastNameAndAge(@Param("lastName") String lastName, @Param("age") Integer age);

}
