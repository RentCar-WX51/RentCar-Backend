package rentcar.rentcarbackend.security.domain.persistence;

import rentcar.rentcarbackend.security.domain.model.entity.Role;
import rentcar.rentcarbackend.security.domain.model.enumeration.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(Roles name);

    boolean existsByName(Roles name);

}