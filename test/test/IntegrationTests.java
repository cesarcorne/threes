package test;

import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import threes.ThreesBoard;
import threes.ThreesController;
import threes.ThreesTile;

/**
 * Esta suite de test se corresponde con el ejercicio 7,
 * la misma hace test de integracion sobre la clase ThreesController,
 * buscando conseguir un %70 de covertura de nodos en los metodos move_up,
 * move_down, move_left, move_right
 * */

public class IntegrationTests {

	/**
	 * Si usamos el constructor por defecto del controller,
	 * entonces, el tablero tiene que tener 9 tiles y podemos movernos en todas
	 * las direcciones al menos una vez
	 * 
	 * */
	@Test
	public void testDefaultControllerConstructor() {
		ThreesController controller = new ThreesController();
		assertTrue(controller.getBoard().numberOfSetTiles()==9);
		assertThat(controller.move_down(), is(equalTo(true)));
		assertThat(controller.move_left(), is(equalTo(true)));
		assertThat(controller.move_right(), is(equalTo(true)));
		assertThat(controller.move_up(), is(equalTo(true)));
	}

	
	/**
	 * Si el tablero que seteamos al controlador es vacio, 
	 * podemos movernos en cualquier direccion pero el tablero no se modifica
	 * (no hay nada para mover)
	 * */
	@Test
	public void testEmptyBoard() {
		ThreesBoard board = new ThreesBoard();
		ThreesController controller = new ThreesController(board);
		assertThat(controller.move_down(), is(equalTo(true)));
		assertThat(controller.move_down(), is(equalTo(true)));
		
		assertThat(controller.move_left(), is(equalTo(true)));
		assertThat(controller.move_left(), is(equalTo(true)));
		
		assertThat(controller.move_right(), is(equalTo(true)));
		assertThat(controller.move_right(), is(equalTo(true)));
		
		assertThat(controller.move_up(), is(equalTo(true)));
		assertThat(controller.move_up(), is(equalTo(true)));
		System.out.print(controller.getBoard().numberOfSetTiles());
		assertTrue(controller.getBoard().numberOfSetTiles() == 0);
		
	}
	
	
	/**
	 * Creamos un nuevo tablero, para luego moverse a la izquierda y despues
	 * dos veces abajo, luego de cada movimiento se chequea el estado del 
	 * tablero
	 * */
	@Test
	public void testMoveLDD() {
		ThreesBoard board = new ThreesBoard();
		
		board.set_tile(0, 0, 0);
		board.set_tile(0, 1, 2);
		board.set_tile(0, 2, 1);
		board.set_tile(0, 3, 0);
		
		board.set_tile(1, 0, 3);
		board.set_tile(1, 1, 3);
		board.set_tile(1, 2, 0);
		board.set_tile(1, 3, 0);
		
		board.set_tile(2, 0, 1);
		board.set_tile(2, 1, 3);
		board.set_tile(2, 2, 0);
		board.set_tile(2, 3, 1);
		
		board.set_tile(3, 0, 1);
		board.set_tile(3, 1, 3);
		board.set_tile(3, 2, 0);
		board.set_tile(3, 3, 0);
		ThreesController controller = new ThreesController(board);
		assertThat(controller.move_left(), is(equalTo(true)));
		assertThat(controller.getBoard().get_tile(1, 0).getValue(), is(equalTo(6)));
		assertThat(controller.move_down(), is(equalTo(true)));
		assertThat(controller.getBoard().get_tile(1, 1).getValue(), is(equalTo(1)));
		assertThat(controller.move_down(), is(equalTo(true)));
		assertThat(controller.getBoard().get_tile(3, 1).getValue(), is(equalTo(6)));
	}
	
	/**
	 * Creamos un nuevo tablero, para luego moverse arriba y despues
	 * dos veces a la derecha, luego de cada movimiento se chequea el estado del 
	 * tablero
	 * */
	@Test
	public void testMoveURR() {
		ThreesBoard board = new ThreesBoard();
		
		board.set_tile(0, 0, 1);
		board.set_tile(0, 1, 0);
		board.set_tile(0, 2, 1);
		board.set_tile(0, 3, 0);
		
		board.set_tile(1, 0, 1);
		board.set_tile(1, 1, 2);
		board.set_tile(1, 2, 0);
		board.set_tile(1, 3, 0);
		
		board.set_tile(2, 0, 0);
		board.set_tile(2, 1, 0);
		board.set_tile(2, 2, 0);
		board.set_tile(2, 3, 0);
		
		board.set_tile(3, 0, 0);
		board.set_tile(3, 1, 0);
		board.set_tile(3, 2, 0);
		board.set_tile(3, 3, 0);
		ThreesController controller = new ThreesController(board);
		assertThat(controller.move_up(), is(equalTo(true)));
		ThreesBoard auxBoard = controller.getBoard();
		assertThat(auxBoard.get_tile(0, 0).getValue(), is(equalTo(1)));
		assertThat(auxBoard.get_tile(0, 1).getValue(), is(equalTo(2)));
		assertThat(auxBoard.get_tile(0, 2).getValue(), is(equalTo(1)));
		assertThat(auxBoard.get_tile(0, 3).getValue(), is(equalTo(0)));
		
		assertThat(controller.move_right(), is(equalTo(true)));
		auxBoard = controller.getBoard();
		assertThat(auxBoard.get_tile(0, 1).getValue(), is(equalTo(1)));
		assertThat(auxBoard.get_tile(0, 2).getValue(), is(equalTo(2)));
		assertThat(auxBoard.get_tile(0, 3).getValue(), is(equalTo(1)));
		
		assertThat(controller.move_right(), is(equalTo(true)));
		assertThat(controller.getBoard().get_tile(0, 3).getValue(), is(equalTo(3)));	
	}

	/**
	 * Creamos un nuevo tablero, para luego moverse abajo,
	 * para luego comprobar que el tamblero no puede realizar moviemientos
	 * y por lo tanto el juego finalizo
	 * */
	@Test
	public void testMoveUThenFinished() {
		ThreesBoard board = new ThreesBoard();
		
		board.set_tile(0, 0, 6);
		board.set_tile(0, 1, 12);
		board.set_tile(0, 2, 96);
		board.set_tile(0, 3, 96);
		
		board.set_tile(1, 0, 12);
		board.set_tile(1, 1, 6);
		board.set_tile(1, 2, 96);
		board.set_tile(1, 3, 48);
		
		board.set_tile(2, 0, 24);
		board.set_tile(2, 1, 48);
		board.set_tile(2, 2, 24);
		board.set_tile(2, 3, 96);
		
		board.set_tile(3, 0, 48);
		board.set_tile(3, 1, 24);
		board.set_tile(3, 2, 12);
		board.set_tile(3, 3, 6);
		ThreesController controller = new ThreesController(board);
		assertThat(controller.move_up(), is(equalTo(true)));
		assertThat(controller.move_up(), is(equalTo(false)));
		assertThat(controller.move_left(), is(equalTo(false)));
		assertThat(controller.move_right(), is(equalTo(false)));
		assertThat(controller.move_down(), is(equalTo(false)));
		assertThat(controller.getBoard().isFinished(), is(equalTo(true)));
	}
	
	
}
