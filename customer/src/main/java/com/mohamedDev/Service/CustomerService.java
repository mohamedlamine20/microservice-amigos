package com.mohamedDev.Service;

import com.mohamedDev.DTO.CustomerRequest;
import com.mohamedDev.DTO.FraudCheckResponse;
import com.mohamedDev.DTO.Message;
import com.mohamedDev.Repository.CustomerRepository;
import com.mohamedDev.module.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {
private  final CustomerRepository customerRepository;

private final RestTemplate restTemplate;
private final RabbitTemplate rabbitTemplate;

private final MailService mailService;

    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer =Customer.builder().firstName(customerRequest.firstName()).lastName(customerRequest.lastName())
                .email(customerRequest.email()).build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse response = restTemplate.getForObject("http://FRAUD/fraud/{customerId}",
                FraudCheckResponse.class, customer.getId()
        );
        if (response.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
       // Message message= Message.builder().messageId(UUID.randomUUID().toString()).createdAt(new Date()).message("add new customer").build();
    //rabbitTemplate.convertAndSend("message","message",message);
   // mailService.sendSimpleEmail("mbounab@wissalgroup.com","hello","test");
    }
}
