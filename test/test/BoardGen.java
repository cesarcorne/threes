package test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.experimental.theories.ParametersSuppliedBy;

/**
 * 
 * Interfaz necesaria para la implementación del generador de la teoria.
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(BoardGenSupplier.class)
public @interface BoardGen {
	// Cantidad de tableros, parametro a utilizar por el usuario del generador.
	int count_boards();
}
