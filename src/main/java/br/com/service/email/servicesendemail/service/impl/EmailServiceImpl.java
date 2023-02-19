package br.com.service.email.servicesendemail.service.impl;

import br.com.service.email.servicesendemail.dto.EmailDto;
import br.com.service.email.servicesendemail.enums.StatusEmail;
import br.com.service.email.servicesendemail.model.EmailModel;
import br.com.service.email.servicesendemail.repository.EmailRepository;
import br.com.service.email.servicesendemail.service.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;

    private final JavaMailSender emailSender;

    public EmailServiceImpl(EmailRepository emailRepository,
                            JavaMailSender emailSender){
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }

    @Override
    public ResponseEntity execute(EmailDto dto) {
        var model = new EmailModel();
        BeanUtils.copyProperties(dto, model);

        model.setSendDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(model.getEmailFrom());
            message.setTo(model.getEmailTo());
            message.setSubject(model.getSubject());
            message.setText(model.getText());
            emailSender.send(message);

            model.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            model.setStatusEmail(StatusEmail.ERROR);
        } finally {
            emailRepository.save(model);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(model);
    }
}
