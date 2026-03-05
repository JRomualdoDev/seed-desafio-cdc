package br.com.deveficiente.livros.novaCompra;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NovoPedidoRequest {

    @Positive
    @NotNull
    private BigDecimal total;

    @Size(min = 1)
    @Valid
    private List<NovoPedidoItemRequest> itens = new ArrayList<>();

    public NovoPedidoRequest(
            @Positive @NotNull BigDecimal total,
            @Size(min = 1) @Valid List<NovoPedidoItemRequest> itens) {
        this.total = total;
        this.itens = itens;
    }
}
