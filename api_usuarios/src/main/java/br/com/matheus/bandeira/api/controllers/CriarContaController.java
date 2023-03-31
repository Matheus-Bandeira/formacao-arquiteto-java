package br.com.matheus.bandeira.api.controllers;

import br.com.matheus.bandeira.application.dtos.CriarContaDTO;
import br.com.matheus.bandeira.application.dtos.CriarContaResponseDTO;
import br.com.matheus.bandeira.application.interfaces.IUsuarioAppService;
import br.com.matheus.bandeira.infrastructure.producers.MessageProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriarContaController {

    @Autowired
    private IUsuarioAppService usuarioAppService;

    @Autowired
    MessageProducer messageProducer;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/api/usuarios/criar-conta")
    public ResponseEntity<CriarContaResponseDTO> post(@Valid @RequestBody CriarContaDTO dto) {

        CriarContaResponseDTO criarContaResponseDTO = new CriarContaResponseDTO();
        HttpStatus status = null;
        try {
             criarContaResponseDTO = usuarioAppService.criarConta(dto);
             //criarContaResponseDTO.setMensagem("Usuario gravado com sucesso!");

             status = HttpStatus.CREATED;

             // enviar para topico
            String mensagem = objectMapper.writeValueAsString(criarContaResponseDTO);
            messageProducer.send(mensagem);
        }catch (IllegalArgumentException ex) {
            criarContaResponseDTO.setMensagem(ex.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(status).body(criarContaResponseDTO);
    }
}
