package br.com.deveficiente.livros.novoEstado;

import br.com.deveficiente.livros.novoPais.NovoPaisResponse;

public class NovoEstadoResponse {

    private Long id;
    private String nome;
    private NovoPaisResponse pais;

    public NovoEstadoResponse(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.pais = new NovoPaisResponse(estado.getPais());
    }
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public NovoPaisResponse getPais() {
        return pais;
    }
}
