package br.com.matheus.bandeira.consumers;

import br.com.matheus.bandeira.components.EmailMessageComponent;
import br.com.matheus.bandeira.dtos.EmailMessageDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.support.ObjectNameManager;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class EmailMessageConsumer {

    @Autowired
    private EmailMessageComponent emailMessageComponent;


    @RabbitListener(queues = { "${queue.name}" })
    public void receive(@Payload String payload) throws  Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // deserializar o conteudo da fila
        EmailMessageDTO dto = objectMapper.readValue(payload, EmailMessageDTO.class);

        //enviando o email
        emailMessageComponent.sendMessagem(dto);
    }
}
