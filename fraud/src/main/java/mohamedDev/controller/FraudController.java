package mohamedDev.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mohamedDev.DTO.FraudCheckResponse;
import mohamedDev.service.FraudService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fraud")
@Slf4j
public class FraudController {
    private  final FraudService fraudService;

    @GetMapping ("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId")Integer customerId){
        log.info("");
    return new FraudCheckResponse(fraudService.isFraudulentCustomer(customerId));
    }
}
