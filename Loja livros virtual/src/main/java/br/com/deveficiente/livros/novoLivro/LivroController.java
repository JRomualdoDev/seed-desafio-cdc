package br.com.deveficiente.livros.novoLivro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("livros")
public class LivroController {


    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public String newLivro(@RequestBody @Valid NovoLivroRequest request) {

        Livro livro = request.toModel(em);
        em.persist(livro);

        return livro.toString();
    }

    @GetMapping
    @Transactional
    public List<ListaLivroOutput> listaLivros() {

        List<Livro> livros = em.createQuery("SELECT l FROM Livro l", Livro.class).getResultList();

        return livros.stream()
                .map( livro -> new ListaLivroOutput(
                        livro.getId(),
                        livro.getTitulo()
                ))
                .collect(Collectors.toList());
    }
}
