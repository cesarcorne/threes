package test;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.allOf;
import threes.AnotherThreesController;
import threes.ThreesBoard;
import threes.ThreesController;

/**
 * esta suite de tests es para el ejercicio 6,
 * en BoardGen y BoardGenSupplier se encuentra el generador pedido en el ejercicio
 * Los tests: testCountTiles, testNotFinished y testLimitOfNewTiles
 * son utilizados para testear el generador de tableros
 * 
 * El test: testCanMoveOurMoveUp testea nuestra implementacion de move_up
 * 
 * El test: testCanMoveAnotherMoveUp chequea exactamente lo mismo
 * pero con el .class dado, el mismo no pasa el test.
 * */

@RunWith(Theories.class)
public class SuiteTheoriesTest {

	@Theory
	public void testCountTiles(@BoardGen(count_boards=10) ThreesBoard b){
		assertThat(b.numberOfSetTiles(), is(equalTo(9)));
	}
	
	@Theory
	public void testNotFinished(@BoardGen(count_boards=10) ThreesBoard b){
		assertFalse(b.isFinished());
	}
	
	@Theory
	public void testLimitOfNewTiles(@BoardGen(count_boards=10) ThreesBoard b){
		ThreesController c = new ThreesController(b);
		assumeTrue(c.move_up());
		assertTrue(c.getBoard().numberOfSetTiles()<=10);
	}
	
	@Theory
	public void testCanMoveOurMoveUp(@BoardGen(count_boards=10) ThreesBoard board) {
		ThreesController c = new ThreesController(board);
		assumeTrue(board.can_move_up());
		assertThat(c.move_up(), is(equalTo(true)));
	}

	@Theory
	public void testCanMoveAnotherMoveUp(@BoardGen(count_boards=10) ThreesBoard board){
		AnotherThreesController c2 = new AnotherThreesController(board);
		assumeTrue(board.can_move_up());
		assertThat(c2.move_up(), is(equalTo(true)));
	}
}
