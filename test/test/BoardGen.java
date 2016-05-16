package test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.experimental.theories.ParametersSuppliedBy;

/**
 * Interfaz necesaria para la implementación del generador
 * */

@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(BoardGenSupplier.class)
public @interface BoardGen {
	int count_boards();
}
