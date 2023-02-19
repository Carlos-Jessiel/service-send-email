package br.com.service.email.servicesendemail.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmailDto {

    private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    private LocalDateTime sendDateEmail;

}
