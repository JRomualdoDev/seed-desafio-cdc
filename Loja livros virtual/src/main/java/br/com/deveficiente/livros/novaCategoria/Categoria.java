package br.com.deveficiente.livros.novaCategoria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    private LocalDateTime instanteCriacao = LocalDateTime.now();

    public Categoria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Categoria() {}

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", instanteCriacao=" + instanteCriacao +
                '}';
    }
}
