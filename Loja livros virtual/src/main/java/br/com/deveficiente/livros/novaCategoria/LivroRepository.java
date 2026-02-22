package br.com.deveficiente.livros.novaCategoria;

import br.com.deveficiente.livros.novoLivro.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {
}
