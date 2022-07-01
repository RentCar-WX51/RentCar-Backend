package rentcar.rentcarbackend.security.domain.service;

import rentcar.rentcarbackend.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {

    void seed();

    List<Role> getAll();
}