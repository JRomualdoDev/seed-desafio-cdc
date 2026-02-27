package br.com.deveficiente.livros.novoLivro;

import br.com.deveficiente.livros.novoAutor.Autor;

public class DetalhesLivroAutorResponse {

    private String nome;
    private String descricao;

    public DetalhesLivroAutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
