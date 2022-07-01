package rentcar.rentcarbackend.tags.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rentcar.rentcarbackend.tags.domain.model.entity.Tag;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    @Query(value = "SELECT * from tags where name like '%:name%'", nativeQuery = true)
    List<Tag> fetchByName(@Param("name") String name);
}
