package br.com.deveficiente.livros.novoAutor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public String newAutor(@RequestBody @Valid NovoAutorRequest request) {
        Autor autor = request.toModel();
        em.persist(autor);
        return autor.toString();
    }

}
