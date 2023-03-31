package br.com.matheus.bandeira.infrastructure.producers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageProducer {

    //nome do topico para o qual a mensagem será enviada
    @Value("${topic.name.producer}")
    private String topico;


    //executar o apache kafka
    private final KafkaTemplate<String, String> kafkaTemplate;

    //método para disparar a mensagem para a fila
    public void send(String message) {
        kafkaTemplate.send(topico, message);
    }
}
