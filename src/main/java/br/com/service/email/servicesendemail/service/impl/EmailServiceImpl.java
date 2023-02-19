package br.com.service.email.servicesendemail.service.impl;

import br.com.service.email.servicesendemail.dto.EmailDto;
import br.com.service.email.servicesendemail.repository.EmailRepository;
import br.com.service.email.servicesendemail.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;

    public EmailServiceImpl(EmailRepository emailRepository){
        this.emailRepository = emailRepository;
    }

    @Override
    public ResponseEntity execute(EmailDto dto) {
        // TODO: desenvolver logica
        return null;
    }
}
