package br.com.matheus.bandeira.application.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RecuperarSenhaDTO {

    @Email(message = "Informe um endereço de email válido.")
    @NotBlank(message = "Email de acesso é obrigatório.")
    private String email;
}
