package br.eti.kge.OSApiApplication.api.controller;

import br.eti.kge.OSApiApplication.domain.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kaylane
 */
@RestController
public class ClienteController {
    
    @PersistenceContext
    private EntityManager manager;
    
    @GetMapping("/clientes")
    public List<Cliente> listas() {
       
        return manager.createQuery("from Cliente", Cliente.class).getResultList();
    }
    
}
