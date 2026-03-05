package br.com.deveficiente.livros.novaCompra;

import br.com.deveficiente.livros.compartilhado.Documento;
import br.com.deveficiente.livros.compartilhado.ExistsId;
import br.com.deveficiente.livros.novoEstado.Estado;
import br.com.deveficiente.livros.novoPais.Pais;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@Entity
public class NovaCompraRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @Documento
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    @ExistsId(domainClass = Estado.class, fieldName = "id")
    private Long idEstado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @Transient
    @Valid
    @NotNull
    private NovoPedidoRequest pedido;

    public NovaCompraRequest(
            @NotBlank @Email String email,
            @NotBlank String nome,
            @NotBlank String sobrenome,
            @NotBlank @Documento String documento,
            @NotBlank String endereco,
            @NotBlank String complemento,
            @NotBlank String cidade,
            @NotNull Long idPais,
            Long idEstado,
            @NotBlank String telefone,
            @NotBlank String cep,
            @Valid @NotNull NovoPedidoRequest pedido
    ) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;

        if (idEstado != null) {
            this.idEstado = idEstado;
        }

        this.telefone = telefone;
        this.cep = cep;
        this.pedido = pedido;
    }

    public NovaCompraRequest() {

    }

    public String getDocumento() {
        return documento;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    @Override
    public String toString() {
        return "NovaCompraRequest{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", idPais=" + idPais +
                ", idEstado=" + idEstado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    public Compra toModel(EntityManager em) {

        @NotNull Pais pais = em.find(Pais.class, idPais);

        return new Compra(
                email,
                nome,
                sobrenome,
                documento,
                endereco,
                complemento,
                pais,
                telefone,
                cep
        );
    }
}
