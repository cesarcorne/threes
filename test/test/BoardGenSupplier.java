package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

import threes.ThreesBoard;

/**
 * Generador de parametros:
 * el mismo genera la cantidad solicitada por el usuario del generador,
 * ademas crea los tableros con 9 elementos 
 * (como lo hace por defecto el juego al comenzar)
 * */

public class BoardGenSupplier extends ParameterSupplier {

	@Override
	public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
		BoardGen annotation = sig.getAnnotation(BoardGen.class);
		int cb = annotation.count_boards();
		List<PotentialAssignment> values = new ArrayList<PotentialAssignment>();
		for (int i = 0; i < cb; i++) {
			ThreesBoard board = new ThreesBoard(9);
			values.add(PotentialAssignment.forValue(Integer.toString(i), board));
		}
		return values;
	}

}
