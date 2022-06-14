package br.eti.kge.OSApiApplication.domain.service;

import br.eti.kge.OSApiApplication.domain.model.OrdemServico;
import br.eti.kge.OSApiApplication.domain.model.StatusOrdemServico;
import br.eti.kge.OSApiApplication.domain.repository.OrdemServicoRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kaylane
 */
@Service
public class OrdemServicoService {
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    public OrdemServico criar(OrdemServico ordemServico) {
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());
        
        return ordemServicoRepository.save(ordemServico);
    } 
    
    public OrdemServico finalizar(OrdemServico ordemServico) {
        ordemServico.setStatus(StatusOrdemServico.FINALIZADA);
        ordemServico.setDataFinalizacao(LocalDateTime.now());
       
        return ordemServicoRepository.save(ordemServico);
    }
    
    public OrdemServico cancelar(OrdemServico ordemServicoID) {
        ordemServicoID.setStatus(StatusOrdemServico.CANCELADA);
        ordemServicoID.setDataFinalizacao(LocalDateTime.now());
        
        return ordemServicoRepository.save(ordemServicoID);
    }
    
    public void excluir(Long OrdemServico_Id) {
        ordemServicoRepository.deleteById(OrdemServico_Id);
    }
}
