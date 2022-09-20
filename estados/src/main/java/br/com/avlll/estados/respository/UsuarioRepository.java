package br.com.avlll.estados.respository;

import br.com.avlll.estados.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{}
