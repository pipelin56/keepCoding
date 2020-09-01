package felipe.bc.currencyconversionservice.controller;

import felipe.bc.currencyconversionservice.datasource.CurrencyExchangeServiceDataSoruce;
import felipe.bc.currencyconversionservice.model.CurrencyConversionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/currency-conversion-service/v1/convert")
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceDataSoruce currencyExchangeServiceDataSoruce;

    @GetMapping("/from/{from}/to/{to}/{quantity}")
    public CurrencyConversionDTO convertCurrency(@PathVariable String from,
                                                 @PathVariable String to,
                                                 @PathVariable BigDecimal quantity) {
        CurrencyConversionDTO conversionDTO = currencyExchangeServiceDataSoruce.getExchangeValue(from, to);
        if(Objects.nonNull(conversionDTO)){
            CurrencyConversionDTO result = new CurrencyConversionDTO();
            result.setFrom(conversionDTO.getFrom());
            result.setTo(conversionDTO.getTo());
            result.setId(conversionDTO.getId());
            result.setQuantity(quantity);
            result.setPort(conversionDTO.getPort());
            result.setConversionMultiple(conversionDTO.getConversionMultiple());
            result.setResult(conversionDTO.getConversionMultiple().multiply(quantity));
            return result;
        };
        return null;
    }
}
