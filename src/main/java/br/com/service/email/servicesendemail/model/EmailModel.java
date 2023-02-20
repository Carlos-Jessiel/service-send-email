package br.com.service.email.servicesendemail.model;

import br.com.service.email.servicesendemail.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "TB_EMAIL")
@NoArgsConstructor
@AllArgsConstructor
public class EmailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;

    // Email de quem esta enviando
    private String emailFrom;

    // Email pra quem sera enviado
    private String emailTo;

    // Titulo email
    private String subject;

    // Coluna que receberá o corpo do email
    @Column(columnDefinition = "TEXT")
    private String text;

    // Data de envio do email
    private LocalDateTime sendDateEmail;

    // Status do email anotado para salvar no banco pelo status
    @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;

}
