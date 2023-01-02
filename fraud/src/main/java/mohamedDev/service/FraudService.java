package mohamedDev.service;

import lombok.RequiredArgsConstructor;
import mohamedDev.module.Fraud;
import mohamedDev.repository.FraudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudService {
    private final FraudRepository fraudRepository;

    public Boolean isFraudulentCustomer(Integer customerId){
        fraudRepository.save(Fraud.builder().
                isFraudster(false).
                customerId(customerId).createdAt(LocalDateTime.now()).build());
        return false;
    }

}
