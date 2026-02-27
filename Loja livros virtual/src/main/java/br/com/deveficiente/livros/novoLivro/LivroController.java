package br.com.deveficiente.livros.novoLivro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public List<ListaLivroResponse> listaLivros() {

        List<Livro> livros = em.createQuery("SELECT l FROM Livro l", Livro.class).getResultList();

        return livros.stream()
                .map( livro -> new ListaLivroResponse(
                        livro.getId(),
                        livro.getTitulo()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    @Transactional
    public ResponseEntity<?> listaLivroPorId(@PathVariable("id") Long id) {

        Livro livro = em.find(Livro.class, id);

        if (livro == null) {
            return ResponseEntity.notFound().build();
        }

        System.out.println( livro.getResumo());
        return ResponseEntity.ok(new ListaLivroPorIDResponse(livro));
    }
}
