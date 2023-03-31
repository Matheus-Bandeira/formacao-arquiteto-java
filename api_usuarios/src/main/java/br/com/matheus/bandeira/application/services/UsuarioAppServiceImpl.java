package br.com.matheus.bandeira.application.services;

import br.com.matheus.bandeira.application.dtos.CriarContaDTO;
import br.com.matheus.bandeira.application.dtos.CriarContaResponseDTO;
import br.com.matheus.bandeira.application.dtos.EmailMessageDTO;
import br.com.matheus.bandeira.application.interfaces.IUsuarioAppService;
import br.com.matheus.bandeira.domain.interfaces.IUsuarioDomainService;
import br.com.matheus.bandeira.domain.models.Usuario;
import br.com.matheus.bandeira.infrastructure.producers.MessageProducerRabbitMQ;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioAppServiceImpl implements IUsuarioAppService {

    @Autowired
    private IUsuarioDomainService domainService;

    @Autowired
    private MessageProducerRabbitMQ messageProducerRabbitMQ;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public CriarContaResponseDTO criarConta(CriarContaDTO dto) {

        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(dto, Usuario.class);
        domainService.criarConta(usuario);

        CriarContaResponseDTO response = modelMapper.map(usuario, CriarContaResponseDTO.class);
        response.setMensagem("Conta de usuário criada com sucesso");

        //escrevendo uma mensagem para o usuario
        EmailMessageDTO emailMessageDTO = new EmailMessageDTO();
        emailMessageDTO.setTo(usuario.getEmail());
        emailMessageDTO.setSubject("Parabéns " + usuario.getNome() + " , sua conta foi criada com sucesso!");
        emailMessageDTO.setBody("Olá, sua conta de usuário foi criada com sucesso em nosso sistema!<br/>Att,<br/>API Usuarios");

        try {
            // serializando a mensagem e enviando para a fila
            messageProducerRabbitMQ.send(objectMapper.writeValueAsString(emailMessageDTO));
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return response;
    }
}
