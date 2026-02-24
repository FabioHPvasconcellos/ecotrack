package br.com.ecotrack.ecotrack.repository;

import br.com.ecotrack.ecotrack.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Metodo extra para buscarmos usuários pelo e-mail no futuro login
    Usuario findByEmail(String email);
}