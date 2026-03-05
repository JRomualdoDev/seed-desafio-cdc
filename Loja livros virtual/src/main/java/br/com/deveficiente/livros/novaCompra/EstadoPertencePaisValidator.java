package br.com.deveficiente.livros.novaCompra;

import br.com.deveficiente.livros.novoEstado.Estado;
import br.com.deveficiente.livros.novoPais.Pais;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EstadoPertencePaisValidator implements Validator {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors()) {
            return;
        }
        NovaCompraRequest request = (NovaCompraRequest) target;

        Pais pais = em.find(Pais.class, request.getIdPais());
        Estado estado = em.find(Estado.class, request.getIdEstado());

        if(!estado.pertencePais(pais)) {
            errors.rejectValue("idEstado", null, "este estado não é o do pais selecionado");
        }
    }
}
