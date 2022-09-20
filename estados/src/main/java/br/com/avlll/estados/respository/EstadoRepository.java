package br.com.avlll.estados.respository;

import br.com.avlll.estados.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado,Long>{}
