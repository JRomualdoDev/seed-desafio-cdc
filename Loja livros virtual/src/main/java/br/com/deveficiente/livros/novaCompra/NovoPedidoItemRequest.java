package br.com.deveficiente.livros.novaCompra;

import br.com.deveficiente.livros.compartilhado.ExistsId;
import br.com.deveficiente.livros.novoLivro.Livro;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class NovoPedidoItemRequest {

    @NotNull
    @ExistsId(domainClass = Livro.class, fieldName = "id")
    private Long livroId;

    @Positive
    private int quantidade;

    public NovoPedidoItemRequest(@NotNull int quantidade, @Positive Long livroId) {
        this.quantidade = quantidade;
        this.livroId = livroId;
    }

    public Long getLivroId() {
        return livroId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "NovoPedidoItemRequest{" +
                "livroId=" + livroId +
                ", quantidade=" + quantidade +
                '}';
    }
}
