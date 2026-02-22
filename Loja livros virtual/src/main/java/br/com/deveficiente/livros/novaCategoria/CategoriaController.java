package br.com.deveficiente.livros.novaCategoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public String newCategoria(@RequestBody @Valid NovoCategoriaRequest request) {
        Categoria categoria = request.toModel();
        em.persist(categoria);
        return categoria.toString();
    }
}
