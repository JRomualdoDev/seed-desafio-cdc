package br.com.deveficiente.livros.compartilhado;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = {})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@ConstraintComposition(CompositionType.OR)
@ReportAsSingleViolation
@CPF
@CNPJ
public @interface Documento {

    String message() default "{com.deveficiente.livros.compartilhado.Documento}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
