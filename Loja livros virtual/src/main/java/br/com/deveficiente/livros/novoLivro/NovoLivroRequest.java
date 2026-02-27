package br.com.deveficiente.livros.novoLivro;

import br.com.deveficiente.livros.compartilhado.UniqueValue;
import br.com.deveficiente.livros.novaCategoria.Categoria;
import br.com.deveficiente.livros.novoAutor.Autor;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.*;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDate;
public class NovoLivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private int numeroPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    private Long idCategoria;

    @NotNull
    private Long idAutor;

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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Long getCategoria() {
        return idCategoria;
    }

    public void setCategoria(Long categoria) {
        this.idCategoria = categoria;
    }

    public Long getAutor() {
        return idAutor;
    }

    public void setAutor(Long autor) {
        this.idAutor = autor;
    }

    public Livro toModel(EntityManager em) {

        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setResumo(resumo);

        if (sumario != null) {
            livro.setSumario(sumario);
        }

        livro.setPreco(preco);
        livro.setNumeroPaginas(numeroPaginas);
        livro.setIsbn(isbn);
        livro.setDataPublicacao(dataPublicacao);

        Categoria existeCategoria = em.find(Categoria.class,idCategoria);
        Assert.state(existeCategoria != null, "Você está querendo cadastrar um livro para uma categoria que não existe no banco " + existeCategoria);
        livro.setCategoria(existeCategoria);

        Autor existeAutor = em.find(Autor.class,idAutor);
        Assert.state(existeAutor != null, "Você está querendo cadastrar um livro para um autor que não existe no banco " + existeAutor);
        livro.setAutor(existeAutor);

        return livro;
    }

    @Override
    public String toString() {
        return "NovoLivroRequest{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", categoria=" + idCategoria+
                ", autor=" + idAutor +
                '}';
    }
}
