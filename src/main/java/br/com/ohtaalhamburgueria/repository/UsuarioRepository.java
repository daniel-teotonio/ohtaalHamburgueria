package br.com.ohtaalhamburgueria.repository;

import br.com.ohtaalhamburgueria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findUsuarioByIdUsuario(Integer idUsuario);
}
