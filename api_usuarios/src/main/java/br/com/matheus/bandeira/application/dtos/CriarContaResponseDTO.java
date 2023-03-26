package br.com.matheus.bandeira.application.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CriarContaResponseDTO {

    private String mensagem;
    private String id;
    private String nome;
    private String email;
}
