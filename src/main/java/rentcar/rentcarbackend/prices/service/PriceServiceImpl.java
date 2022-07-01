package rentcar.rentcarbackend.prices.service;

import org.springframework.stereotype.Service;
import rentcar.rentcarbackend.prices.domain.model.entity.Price;

import java.util.List;
import java.util.Optional;

//@AllArgsConstructor
@Service
public class PriceServiceImpl implements rentcar.rentcarbackend.prices.domain.service.PriceService {

    //@Autowired
    private final rentcar.rentcarbackend.prices.domain.persistence.PriceRepository priceRepository;

    public PriceServiceImpl(rentcar.rentcarbackend.prices.domain.persistence.PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price create(Price price) {
        return priceRepository.save(price);
    }

    @Override
    public Price update(Price price) {
        return priceRepository.save(price);
    }

    @Override
    public List<Price> getAll() {
        return priceRepository.findAll();
    }

    @Override
    public Optional<Price> getById(Integer id) {
        return priceRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        priceRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return priceRepository.existsById(id);
    }

}
