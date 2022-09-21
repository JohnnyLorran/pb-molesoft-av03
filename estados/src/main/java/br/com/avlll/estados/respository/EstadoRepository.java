package br.com.avlll.estados.respository;

import br.com.avlll.estados.model.Estado;
import br.com.avlll.estados.model.Regiao;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado,Long>{

    List<Estado> findByRegiao(Regiao regiao,Sort sort);

}
