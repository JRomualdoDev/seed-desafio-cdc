package br.com.deveficiente.livros.novoAutor;

import br.com.deveficiente.livros.compartilhado.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class NovoAutorRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public NovoAutorRequest(
            @NotBlank String nome,
            @NotBlank @Email String email,
            @NotBlank @Size(max = 400) String descricao
    ) {
        // Redundante chamar o super aqui
        //super();
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public NovoAutorRequest() {

    }

    public String getEmail() {
        return email;
    }


    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
