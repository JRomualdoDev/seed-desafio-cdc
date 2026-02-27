package br.com.deveficiente.livros.novoEstado;

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
@RequestMapping("/estado")
public class EstadoController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public ResponseEntity<NovoEstadoResponse> novoEstado(@Valid @RequestBody NovoEstadoRequest request) {
        Estado estado = request.toModel(em);
        em.persist(estado);
        return ResponseEntity.ok(new NovoEstadoResponse(estado));
    }
}
