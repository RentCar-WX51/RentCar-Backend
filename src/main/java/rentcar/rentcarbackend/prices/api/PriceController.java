package rentcar.rentcarbackend.prices.api;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rentcar.rentcarbackend.prices.domain.model.entity.Price;
import rentcar.rentcarbackend.prices.shared.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@SecurityRequirement(name = "rentcar")
@RestController
@RequestMapping("/api/v1/prices")
@AllArgsConstructor
public class PriceController {

    private final rentcar.rentcarbackend.prices.domain.service.PriceService priceService;

    @GetMapping
    public List<Price> getAll() {
        List<Price> prices = priceService.getAll();
        prices.forEach(System.out::println);
        return prices;
    }

    @GetMapping("{id}") //  /prices/{id}
    public Price getById(@PathVariable("id") Integer id) {
        if (!priceService.existsById(id)) {
            throw new NotFoundException("Price", id);
        } else {
            Optional<Price> optional = priceService.getById(id);
            return optional.get();
        }
    }
    @PutMapping("{id}")
    public Price updateById(@PathVariable("id") Integer id,
                              @RequestBody Price price) {
        if (!priceService.existsById(id)) {
            throw new NotFoundException("Price", id);
        } else
        {
            return priceService.update(price);
        }
    }

    @PostMapping
    public ResponseEntity<?> createPrice(@RequestBody Price price) {
        Price priceResponse = priceService.create(price);
        return new ResponseEntity<>(priceResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")

    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if (!priceService.existsById(id)) {
            throw new NotFoundException("Price", id);
        } else
        {
            priceService.deleteById(id);
            //return new ResponseEntity<>(HttpStatus.ACCEPTED);
            return ResponseEntity.accepted().build();   // Lambda
        }
    }
}
