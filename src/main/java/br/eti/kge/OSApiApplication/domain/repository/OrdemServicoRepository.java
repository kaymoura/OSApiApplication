package br.eti.kge.OSApiApplication.domain.repository;

import br.eti.kge.OSApiApplication.domain.model.OrdemServico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Kaylane
 */
//@Repository
public interface OrdemServicoRepository  extends JpaRepository<OrdemServico, Long>{
    List<OrdemServico> findById(long id);
    List<OrdemServico> findByDescricao(String descricao);
    OrdemServico deleteById(long id);
}
