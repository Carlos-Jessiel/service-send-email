package br.com.service.email.servicesendemail.service;

import br.com.service.email.servicesendemail.dto.EmailDto;
import org.springframework.http.ResponseEntity;

public interface EmailService {
    ResponseEntity execute(EmailDto dto);
}
