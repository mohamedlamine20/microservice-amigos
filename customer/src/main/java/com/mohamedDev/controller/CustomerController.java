package com.mohamedDev.controller;

import com.google.gson.Gson;
import com.mohamedDev.DTO.CustomerRequest;
import com.mohamedDev.DTO.MailDTO;
import com.mohamedDev.Service.CustomerService;
import com.mohamedDev.Service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;

@Slf4j
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
   private  final  CustomerService customerService;

   private final MailService mailService;
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRequest customerRequest){
        log.info("new customer registration {}",customerRequest);
        customerService.registerCustomer(customerRequest);
    }
    @PostMapping("/send")
    public  void sendMail(@RequestBody MailDTO  mailDTO){
        mailService.sendSimpleEmail(mailDTO.getToEmail(), mailDTO.getBody(),mailDTO.getSubject());
    }

    @PostMapping("/sendMail")
    public void sendMailAttach(@RequestPart("mailDTO") String mailDTO,
                               @RequestPart("attachment")  MultipartFile attachment) throws MessagingException {
        Gson gson=new Gson();
        MailDTO mailDTO1=gson.fromJson(mailDTO,MailDTO.class);
        customerService.sendMailAttach(mailDTO1, attachment);

    }
}
