package br.com.deveficiente.livros.novoPais;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public ResponseEntity<NovoPaisResponse> newPais(@Valid @RequestBody NovoPaisRequest request) {
        Pais pais = request.toModel();

        em.persist(pais);
        return ResponseEntity.ok(new  NovoPaisResponse(pais));
    }
}
