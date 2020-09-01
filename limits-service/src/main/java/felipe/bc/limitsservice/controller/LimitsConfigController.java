package felipe.bc.limitsservice.controller;

import felipe.bc.limitsservice.dto.LimitsConfig;
import felipe.bc.limitsservice.properties.LimitsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limits-service/v1/config")
public class LimitsConfigController {

    @Autowired
    private LimitsProperties limitsProperties;

    @GetMapping("/limits")
    public LimitsConfig getLimits() {
        return new LimitsConfig(limitsProperties.getMin(), limitsProperties.getMax());
    }

}
