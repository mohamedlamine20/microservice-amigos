package com.mohamedDev.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class MailDTO {


     private String toEmail;
     private String body;
     private String subject;
}
