package br.com.deveficiente.livros.novaCompra;

import br.com.deveficiente.livros.compartilhado.Documento;
import br.com.deveficiente.livros.novoPais.Pais;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Compra {

   private @NotBlank @Email String email;
   private @NotBlank String nome;
   private @NotBlank String sobrenome;
   private @NotBlank @Documento String documento;
   private @NotBlank String endereco;
   private @NotBlank String complemento;
   private @NotNull Pais pais;
   private @NotBlank String telefone;
   private @NotBlank String cep;



    public Compra(
            @NotBlank @Email String email,
            @NotBlank String nome,
            @NotBlank String sobrenome,
            @NotBlank @Documento String documento,
            @NotBlank String endereco,
            @NotBlank String complemento,
            @NotNull Pais pais,
            @NotBlank String telefone,
            @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }
}
