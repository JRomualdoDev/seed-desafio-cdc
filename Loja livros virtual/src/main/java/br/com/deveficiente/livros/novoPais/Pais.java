package br.com.deveficiente.livros.novoPais;

import br.com.deveficiente.livros.novoEstado.Estado;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estado> estados = new ArrayList<>();

    public Pais(
            @NotBlank String nome
    ) {
        this.nome = nome;
    }

    public Pais() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
