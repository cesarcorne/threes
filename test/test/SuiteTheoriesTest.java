package test;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import threes.AnotherThreesController;
import threes.ThreesBoard;
import threes.ThreesController;

/**
 * 
 * Esta suite de tests es para el ejercicio 6, en BoardGen y BoardGenSupplier 
 * se encuentra el generador pedido en el ejercicio.
 * 
 * Los tests: testCountTiles, testNotFinished y testLimitOfNewTiles
 * son utilizados para testear el generador de tableros
 * 
 * El test: testCanMoveOurMoveUp testea nuestra implementacion de move_up
 * 
 * El test: testCanMoveAnotherMoveUp chequea exactamente lo mismo
 * pero con el .class dado, el mismo no pasa el test.
 * 
 * */

@RunWith(Theories.class)
public class SuiteTheoriesTest {

	/**
	 * Test que controla que la cantidad de piezas seteadas en el tablero sea 
	 * siempre igual a 9.
	 * 
	 * @param b El board o tablero del juego
	 */
	@Theory
	public void testCountTiles(@BoardGen(count_boards=10) ThreesBoard b){
		assertThat(b.numberOfSetTiles(), is(equalTo(9)));
	}
	
	/**
	 * Test que controla si contiene movimientos disponibles.
	 * 
	 * @param b El board o tablero del juego
	 */	
	@Theory
	public void testNotFinished(@BoardGen(count_boards=10) ThreesBoard b){
		assertFalse(b.isFinished());
	}
	
	/**
	 * Test que controla que si se puede mover hacia arriba la cantidad de 
	 * piezas seteadas en el tablero es menor o igual a 10, es decir que 
	 * inserto al menos una nueva aleatoriamente. 
	 * 
	 * @param b El board o tablero del juego
	 */	
	@Theory
	public void testLimitOfNewTiles(@BoardGen(count_boards=10) ThreesBoard b){
		ThreesController c = new ThreesController(b);
		assumeTrue(c.move_up());
		assertTrue(c.getBoard().numberOfSetTiles()<=10);
	}

	/**
	 * Test que controla que si se puede mover hacia arriba en el tablero  
	 * luego de realizar dicho movimiento el resultado sea true.
	 * 
	 * @param board El board o tablero del juego
	 */		
	@Theory
	public void testCanMoveOurMoveUp(@BoardGen(count_boards=10) ThreesBoard board) {
		ThreesController c = new ThreesController(board);
		assumeTrue(board.can_move_up());
		assertThat(c.move_up(), is(equalTo(true)));
	}


	/**
	 * Test que controla sobre la clase AnotherThreesController dada en el TP 
	 * que si se puede mover hacia arriba en el tablero luego de realizar dicho 
	 * movimiento el resultado sea true.
	 * 
	 * @param board El board o tablero del juego
	 */
	@Theory
	public void testCanMoveAnotherMoveUp(@BoardGen(count_boards=10) ThreesBoard board){
		AnotherThreesController c2 = new AnotherThreesController(board);
		assumeTrue(board.can_move_up());
		assertThat(c2.move_up(), is(equalTo(true)));
	}

}
