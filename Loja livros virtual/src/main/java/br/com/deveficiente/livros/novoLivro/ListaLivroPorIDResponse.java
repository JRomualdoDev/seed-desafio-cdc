package br.com.deveficiente.livros.novoLivro;

import br.com.deveficiente.livros.novoAutor.Autor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ListaLivroPorIDResponse {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private int numeroPaginas;
    private String isbn;
    private String dataPublicacao;
    private DetalhesLivroAutorResponse autor;


    public ListaLivroPorIDResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.autor = new DetalhesLivroAutorResponse(livro.getAutor());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public DetalhesLivroAutorResponse getAutor() {
        return autor;
    }

    public void setAutor(DetalhesLivroAutorResponse autor) {
        this.autor = autor;
    }
}
