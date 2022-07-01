package rentcar.rentcarbackend.security.api;


import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rentcar.rentcarbackend.security.domain.model.entity.Tenant;
import rentcar.rentcarbackend.security.domain.service.TenantService;
import rentcar.rentcarbackend.shared.exception.NotFoundException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tenants")
@AllArgsConstructor

public class TenantController {

    private final TenantService tenantService;

    @GetMapping
    public List<Tenant> getAll() {
        List<Tenant> tenants = tenantService.getAll();
        tenants.forEach(System.out::println);
        return tenants;
    }

    @GetMapping("{id}") //  /tenants/{id}
    public Tenant getById(@PathVariable("id") Integer id) {
        if (!tenantService.existsById(id)) {
            throw new NotFoundException("Tenant", id);
        } else {
            Optional<Tenant> optional = tenantService.getById(id);
            return optional.get();
        }
    }
    @PutMapping("{id}")
    public Tenant updateById(@PathVariable("id") Integer id,
                             @RequestBody Tenant tenant) {
        if (!tenantService.existsById(id)) {
            throw new NotFoundException("Tenant", id);
        } else
        {
            return tenantService.update(tenant);
        }
    }
    //////////////////
    @PostMapping
    public ResponseEntity<?> createTenant(@RequestBody Tenant tenant) {

        Tenant tenantResponse = tenantService.create(tenant);
        return new ResponseEntity<>(tenantResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")

    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if (!tenantService.existsById(id)) {
            throw new NotFoundException("Tenant", id);
        } else
        {
            tenantService.deleteById(id);
            //return new ResponseEntity<>(HttpStatus.ACCEPTED);
            return ResponseEntity.accepted().build();   // Lambda
        }
    }


}
