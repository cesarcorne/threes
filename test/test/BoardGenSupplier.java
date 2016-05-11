package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

import threes.ThreesBoard;

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
