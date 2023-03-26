package br.com.matheus.bandeira.domain.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String _id;
    private String nome;

    @Indexed(unique = true)
    private String email;
    private String senha;
    private Instant dataHoraCriacao;
    private Instant dataHoraUltimaAlteracao;
}
