package br.com.deveficiente.livros.novoEstado;

import br.com.deveficiente.livros.compartilhado.UniqueValue;
import br.com.deveficiente.livros.novoPais.Pais;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.util.Assert;

public class NovoEstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    private Long paisId;

    public NovoEstadoRequest(
            @NotBlank String nome,
            @NotBlank Long paisId
    ) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public NovoEstadoRequest() {}

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Estado toModel(EntityManager em) {

        Pais pais = em.find(Pais.class, paisId);

        Assert.state(pais != null, "Você está querendo cadastrar um Estado para um Pais que não existe no banco " + paisId);

        return new Estado(
                nome,
                pais
        );
    }
}
