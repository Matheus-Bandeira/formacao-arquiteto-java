package br.com.matheus.bandeira.domain.services;

import br.com.matheus.bandeira.domain.interfaces.IUsuarioDomainService;
import br.com.matheus.bandeira.domain.models.Usuario;
import br.com.matheus.bandeira.infrastructure.components.MD5Component;
import br.com.matheus.bandeira.infrastructure.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;


@Service
public class UsuarioDomainServiceImpl implements IUsuarioDomainService {

    @Autowired
    private IUsuarioRepository usuarioRepositoryrepository;

    @Autowired
    private MD5Component md5Component;

    @Override
    public void criarConta(Usuario usuario) {

        Optional<Usuario> optional = usuarioRepositoryrepository.findByEmail(usuario.getEmail());
        if(optional.isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado!");
        }

        usuario.setSenha(md5Component.encrypt(usuario.getSenha()));
        usuario.setDataHoraCriacao(Instant.now());
        usuario.setDataHoraUltimaAlteracao(Instant.now());

        usuarioRepositoryrepository.save(usuario);
    }
}
