package br.eti.kge.OSApiApplication.api.controller;

import br.eti.kge.OSApiApplication.domain.model.OrdemServico;
import br.eti.kge.OSApiApplication.domain.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.eti.kge.OSApiApplication.domain.repository.OrdemServicoRepository;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;
import javax.validation.Valid;

/**
 *
 * @author Kaylane
 */
@RestController
public class OrdemServicoController {
    
    @Autowired
    private OrdemServicoService ordemServicoService;
    
    // Post  -  ABERTA - Criar
    @PostMapping("/ordem-servico")
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@RequestBody OrdemServico ordemServico) {        
        return ordemServicoService.criar(ordemServico);
    }
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    //Get - Buscar
    @GetMapping("/ordem-servico/{ordemServicoID}") 
    public ResponseEntity<Object> buscar(@PathVariable Long ordemServicoID) {
        Optional<OrdemServico> ordem = ordemServicoRepository.findById(ordemServicoID);
        if (ordem.isPresent()) {
            return ResponseEntity.ok(ordem.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //Get - Listar
    @GetMapping("/ordem-servico") 
    public List<OrdemServico> listas() {
        return ordemServicoRepository.findAll();
    }
    
    //Put - Finalizar
    @PutMapping("/ordem-servico/finalizar/{ordemServicoID}")
    public OrdemServico finalizar(OrdemServico ordemServicoID) {        
        return ordemServicoService.finalizar(ordemServicoID);
    }  
    
    //Put - Cancelar 
    @PutMapping("/ordem-servico/cancelar/{ordemServicoID}")
    public OrdemServico cancelar(OrdemServico ordemServicoID) {    
        return ordemServicoService.cancelar(ordemServicoID);
    }   
    
    //Put - Atualizar
    @PutMapping("/ordem-servico/{ordemServicoID}")
    public ResponseEntity<OrdemServico> atualizar(@Valid @PathVariable Long ordemServicoID,
                                             @RequestBody OrdemServico ordem) {
        //Verifica se a ordem existe
        if (!ordemServicoRepository.existsById(ordemServicoID)) {
            return ResponseEntity.notFound().build();
        }
        ordem.setId(ordemServicoID);
        ordem = ordemServicoService.criar(ordem);
        return ResponseEntity.ok(ordem);
    }
    
    // Delete
    @DeleteMapping("/ordem-servico/{ordemServicoID}")
    public ResponseEntity<Void> excluir(@PathVariable Long ordemServicoID) {
        //Verifica se a ordem existe ou não
        
        if(!ordemServicoRepository.existsById(ordemServicoID)) {
            return ResponseEntity.notFound().build();
        }
        
       ordemServicoService.excluir(ordemServicoID);
       return ResponseEntity.noContent().build();
    }
}
