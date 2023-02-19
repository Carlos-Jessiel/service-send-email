package br.com.service.email.servicesendemail.controller;

import br.com.service.email.servicesendemail.dto.EmailDto;
import br.com.service.email.servicesendemail.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService){
        this.emailService = emailService;
    }

    @PostMapping("/sending-email")
    public ResponseEntity sendingEmail(@RequestBody EmailDto dto){
        return emailService.execute(dto);
    }

}
