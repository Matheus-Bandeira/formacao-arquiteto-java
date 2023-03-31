package br.com.matheus.bandeira.components;

import br.com.matheus.bandeira.dtos.EmailMessageDTO;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailMessageComponent {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String userName;

    public void sendMessagem(EmailMessageDTO dto) throws Exception {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(userName);
        helper.setTo(dto.getTo());
        helper.setSubject(dto.getSubject());
        helper.setText(dto.getBody(), true);

        javaMailSender.send(message);
    }
}
