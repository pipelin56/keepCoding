package felipe.bc.currencyexchangeservice.controller;

import felipe.bc.currencyexchangeservice.dto.ExchangeValue;
import felipe.bc.currencyexchangeservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/currency-exchange-service/v1/exchange")
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue ev = exchangeValueRepository.findByFromAndTo(from, to);
        Optional.ofNullable(environment.getProperty("local.server.port"))
                .map(Integer::parseInt).ifPresent(port ->
                Optional.ofNullable(ev).ifPresent(obj -> obj.setPort(port)));
        return ev;
    }
}
