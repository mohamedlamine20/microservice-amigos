package com.mohamedDev.Service;

import com.mohamedDev.DTO.MailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@RequiredArgsConstructor
public class MailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private MailProperties mailProperties;

    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(mailProperties.getUsername());
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail Send...");
    }

    public void sendEmailWithAttachment(MailDTO mailDTO,
                                        MultipartFile attachment) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom(mailProperties.getUsername());
        mimeMessageHelper.setTo(mailDTO.getToEmail());
        mimeMessageHelper.setText(mailDTO.getBody());
        mimeMessageHelper.setSubject(mailDTO.getSubject());

        mimeMessageHelper.addAttachment(attachment.getOriginalFilename(),attachment);

        mailSender.send(mimeMessage);
        System.out.println("Mail Send...");

    }
}
