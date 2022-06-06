package br.eti.kge.OSApiApplication.api.controller;

import br.eti.kge.OSApiApplication.domain.model.OrdemServico;
import br.eti.kge.OSApiApplication.domain.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.eti.kge.OSApiApplication.domain.repository.OrdemServicoRepository;
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
@RequestMapping("/ordem-servico")
public class OrdemServicoController {
    
    @Autowired
    private OrdemServicoService ordemServicoService;
    
    // Post
    @PostMapping("/ordem-servico")
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@RequestBody OrdemServico ordemServico) {
        return ordemServicoService.criar(ordemServico);
    }
    
//    @Autowired
//    private OrdemServicoRepository ordemServicoRepository;
    
//    //Get
//    @GetMapping("/ordem-servico/{clienteID}") // Buscar
//    public ResponseEntity<Object> buscar(@PathVariable Long clienteID) {
//        Optional<OrdemServico> ordem = ordemServicoRepository.findById(clienteID);
//        if (ordem.isPresent()) {
//            return ResponseEntity.ok(ordem.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
    
    
//    //Put
//    @PutMapping("/ordem-servico/{clienteID}")
//    public ResponseEntity<OrdemServico> atualizar(@Valid @PathVariable Long clienteID,
//                                             @RequestBody OrdemServico ordem) {
//        //Verifica se o client existe
//        if (!ordemServicoRepository.existsById(clienteID)) {
//            return ResponseEntity.notFound().build();
//        }
//        
//        ordem.setId(clienteID);
//        ordem = OrdemServicoService.salvar(ordem);
//        return ResponseEntity.ok(ordem);
//    }
//    
//    
//    // Delete
//    @DeleteMapping("/ordem-servico/{clienteID}")
//    public ResponseEntity<Void> excluir(@PathVariable Long clienteID) {
//        //Verifica se cliente existe ou não
//        
//        if(!ordemServicoRepository.existsById(clienteID)) {
//            return ResponseEntity.notFound().build();
//        }
//        
//       ordemServicoService.excluir(clienteID);
//       return ResponseEntity.noContent().build();
//    }
}
