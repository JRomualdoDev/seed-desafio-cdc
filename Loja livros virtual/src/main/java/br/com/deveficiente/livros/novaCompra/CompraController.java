package br.com.deveficiente.livros.novaCompra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private EstadoPertencePaisValidator estadoPertencePaisValidator;

    @PersistenceContext
    private EntityManager em;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoPertencePaisValidator);
    }

    @PostMapping
    public String novaCompra(@RequestBody @Valid NovaCompraRequest request) {
        Compra compra = request.toModel(em);
        return request.toString();
    }
}
