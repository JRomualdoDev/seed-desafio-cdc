package br.com.deveficiente.livros.novoEstado;

import br.com.deveficiente.livros.novoPais.Pais;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    public Estado(
            String nome,
            Pais pais
    ) {
        this.nome = nome;
        this.pais = pais;
    }

    public Estado() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}
