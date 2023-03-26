package br.com.matheus.bandeira.application.services;

import br.com.matheus.bandeira.application.dtos.CriarContaDTO;
import br.com.matheus.bandeira.application.dtos.CriarContaResponseDTO;
import br.com.matheus.bandeira.application.interfaces.IUsuarioAppService;
import br.com.matheus.bandeira.domain.interfaces.IUsuarioDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioAppServiceImpl implements IUsuarioAppService {

    @Autowired
    private IUsuarioDomainService domainService;

    @Override
    public CriarContaResponseDTO criarConta(CriarContaDTO dto) {
        return null;
    }
}
