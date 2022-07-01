package rentcar.rentcarbackend.prices.domain.service;

import rentcar.rentcarbackend.prices.domain.model.entity.Price;

import java.util.List;
import java.util.Optional;

public interface PriceService {
    // CRUD
    Price create(Price price);
    Price update(Price price);
    List<Price> getAll();
    Optional<Price> getById(Integer id);
    void deleteById(Integer id);
    boolean existsById(Integer id);
}
