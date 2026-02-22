package br.com.deveficiente.livros.novaCategoria;

import br.com.deveficiente.livros.compartilhado.UniqueValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NovoCategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public NovoCategoriaRequest(
            @NotBlank  String nome,
            @NotBlank @Size(max=400) String descricao
    ) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public NovoCategoriaRequest() {}

    public String getNome() {
        return nome;
    }


    public Categoria toModel() {
        return new Categoria(this.nome, this.descricao);
    }
}
