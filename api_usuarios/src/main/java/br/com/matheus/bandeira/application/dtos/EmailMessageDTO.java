package br.com.matheus.bandeira.application.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class EmailMessageDTO {

    private String to;
    private String subject;
    private String body;
}
