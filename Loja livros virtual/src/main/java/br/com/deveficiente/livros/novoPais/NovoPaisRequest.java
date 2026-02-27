package br.com.deveficiente.livros.novoPais;

import br.com.deveficiente.livros.compartilhado.UniqueValue;
import br.com.deveficiente.livros.novoEstado.Estado;
import jakarta.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public NovoPaisRequest(
            @NotBlank String nome
    ) {
        this.nome = nome;
    }

    public NovoPaisRequest() {}

    public String getNome() {
        return nome;
    }

    public Pais toModel() {
        return new Pais(nome);
    }

}
