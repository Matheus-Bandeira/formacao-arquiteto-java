package br.com.matheus.bandeira.domain.services;

import br.com.matheus.bandeira.domain.interfaces.IUsuarioDomainService;
import br.com.matheus.bandeira.domain.models.Usuario;
//import br.com.matheus.bandeira.infrastructure.components.MD5Component;
import br.com.matheus.bandeira.infrastructure.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Optional;


@Service
public class UsuarioDomainServiceImpl implements IUsuarioDomainService {

    @Autowired
    private IUsuarioRepository usuarioRepositoryrepository;

    /*@Autowired
    private MD5Component md5Component;*/

    @Override
    public void criarConta(Usuario usuario) {

        Optional<Usuario> optional = usuarioRepositoryrepository.findByEmail(usuario.getEmail());
        if(optional.isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado!");
        }

        //usuario.setSenha(md5Component.criptografarSenha(usuario.getSenha()));
        usuario.setSenha(criptografarSenha(usuario.getSenha()));
        usuario.setDataHoraCriacao(Instant.now());
        usuario.setDataHoraUltimaAlteracao(Instant.now());

        usuarioRepositoryrepository.save(usuario);
    }

    private String criptografarSenha(String senha) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        return hash.toString(16);
    }
}
