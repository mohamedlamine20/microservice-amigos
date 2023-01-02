package com.mohamedDev.controller;

import com.mohamedDev.DTO.CustomerRequest;
import com.mohamedDev.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
   private  final  CustomerService customerService;
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRequest customerRequest){
        log.info("new customer registration {}",customerRequest);
        customerService.registerCustomer(customerRequest);



    }
}
