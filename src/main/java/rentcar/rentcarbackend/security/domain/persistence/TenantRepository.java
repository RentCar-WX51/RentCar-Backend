package rentcar.rentcarbackend.security.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rentcar.rentcarbackend.security.domain.model.entity.Tenant;

import java.util.List;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {


    List<Tenant> findByLastNameAndAge(String lastName, Integer age);
    /*
        @Query(value = "SELECT * from tenants where last_name like '%:lastName%' and age < :age", nativeQuery = true)
        List<Tenant> fetchByLastNameAndAge(@Param("lastName") String lastName,
                                            @Param("age") Integer age);
    */
    @Query(value = "SELECT st from Tenant st where st.lastName like '%:lastName%' and st.age < :age")
    List<Tenant> fetchByLastNameAndAge2(@Param("lastName") String lastName,
                                        @Param("age") Integer age);

}
