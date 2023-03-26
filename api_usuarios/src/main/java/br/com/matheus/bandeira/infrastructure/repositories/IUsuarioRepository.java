package br.com.matheus.bandeira.infrastructure.repositories;

import br.com.matheus.bandeira.domain.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends MongoRepository<Usuario, String> {

    @Query("{email : ?0}")
    Optional<Usuario> findByEmail(String email);

    @Query("{email : ?0, senha : ?1}")
    Optional<Usuario> findByEmailAndSenha(String email, String senha);
}
