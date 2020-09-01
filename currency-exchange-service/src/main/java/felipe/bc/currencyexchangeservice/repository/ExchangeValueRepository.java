package felipe.bc.currencyexchangeservice.repository;

import felipe.bc.currencyexchangeservice.dto.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    public ExchangeValue findByFromAndTo(String from, String to);

}
