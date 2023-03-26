package br.com.matheus.bandeira.application.interfaces;

import br.com.matheus.bandeira.application.dtos.CriarContaDTO;
import br.com.matheus.bandeira.application.dtos.CriarContaResponseDTO;


public interface IUsuarioAppService {

    CriarContaResponseDTO criarConta(CriarContaDTO dto);
}
