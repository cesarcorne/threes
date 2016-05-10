package ejercicio3;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import threes.ThreesBoard;
import threes.ThreesController;
import threes.ThreesTile;

public class PartitionTest {

	/**
	 * Los siguientes tests: B1B1, B1B2, B1B3, B2B1, B3B1
	 * 
	 * corresponden al ejercicio3, 
	 * en el cual utilizabamos la estrategia de combinacion de características
	 * (y bloques) para el metodo move_up.
	 * 
	 * "cobertura de bloque base"
	 * 
	 * */
	@Test
	public void testB1B1() {
		ThreesBoard board = new ThreesBoard();
		
		board.set_tile(0, 0, 1);
		board.set_tile(0, 1, 1);
		board.set_tile(0, 2, 3);
		board.set_tile(0, 3, 2);
		
		board.set_tile(1, 0, 3);
		board.set_tile(1, 1, 2);
		board.set_tile(1, 2, 2);
		board.set_tile(1, 3, 2);
		
		board.set_tile(2, 0, 1);
		board.set_tile(2, 1, 2);
		board.set_tile(2, 2, 2);
		board.set_tile(2, 3, 2);
		
		board.set_tile(3, 0, 1);
		board.set_tile(3, 1, 2);
		board.set_tile(3, 2, 2);
		board.set_tile(3, 3, 2);
		ThreesController controller = new ThreesController(board);
		assertThat(controller.move_up(), is(equalTo(true)));
		ThreesBoard auxBoard = controller.getBoard();
		
		//check the first column
		ThreesTile t1 = auxBoard.get_tile(0, 0);
		ThreesTile t2 = auxBoard.get_tile(1, 0);
		ThreesTile t3 = auxBoard.get_tile(2, 0);
		ThreesTile t4 = auxBoard.get_tile(3, 0);
		assertThat(t1.getValue(), is(equalTo(1)));
		assertThat(t2.getValue(), is(equalTo(3)));
		assertThat(t3.getValue(), is(equalTo(1)));
		assertThat(t4.getValue(), is(equalTo(1)));
		
		//check the second column
		t1 = auxBoard.get_tile(0, 1);
		t2 = auxBoard.get_tile(1, 1);
		t3 = auxBoard.get_tile(2, 1);
		//ThreesTile t4 = auxBoard.get_tile(3, 1);
		assertThat(t1.getValue(), is(equalTo(3)));
		assertThat(t2.getValue(), is(equalTo(2)));
		assertThat(t3.getValue(), is(equalTo(2)));
		//assertThat(t4.getValue(), is(equalTo(0)));
		
		//check the third column
		t1 = auxBoard.get_tile(0, 2);
		t2 = auxBoard.get_tile(1, 2);
		t3 = auxBoard.get_tile(2, 2);
		t4 = auxBoard.get_tile(3, 2);
		assertThat(t1.getValue(), is(equalTo(3)));
		assertThat(t2.getValue(), is(equalTo(2)));
		assertThat(t3.getValue(), is(equalTo(2)));
		assertThat(t4.getValue(), is(equalTo(2)));
		
		//check fourth column
		t1 = auxBoard.get_tile(0, 3);
		t2 = auxBoard.get_tile(1, 3);
		t3 = auxBoard.get_tile(2, 3);
		t4 = auxBoard.get_tile(3, 3);
		assertThat(t1.getValue(), is(equalTo(2)));
		assertThat(t2.getValue(), is(equalTo(2)));
		assertThat(t3.getValue(), is(equalTo(2)));
		assertThat(t4.getValue(), is(equalTo(2)));
				
	}

	@Test
	public void testB1B2() {
		List list_fourth_elements = new ArrayList();
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 0);
		board.set_tile(0, 1, 1);
		board.set_tile(0, 2, 3);
		board.set_tile(0, 3, 0);
		
		board.set_tile(1, 0, 1);
		board.set_tile(1, 1, 0);
		board.set_tile(1, 2, 3);
		board.set_tile(1, 3, 0);
		
		board.set_tile(2, 0, 2);
		board.set_tile(2, 1, 3);
		board.set_tile(2, 2, 1);
		board.set_tile(2, 3, 2);
		
		board.set_tile(3, 0, 2);
		board.set_tile(3, 1, 1);
		board.set_tile(3, 2, 0);
		board.set_tile(3, 3, 1);
		ThreesController controller = new ThreesController(board);
		assertThat(controller.move_up(), is(equalTo(true)));
		ThreesBoard auxBoard = controller.getBoard();
		
		//check values of first column
		ThreesTile t1 = auxBoard.get_tile(0, 0);
		ThreesTile t2 = auxBoard.get_tile(1, 0);
		ThreesTile t3 = auxBoard.get_tile(2, 0);
		ThreesTile t4 = auxBoard.get_tile(3, 0);
		assertThat(t1.getValue(), is(equalTo(1)));
		assertThat(t2.getValue(), is(equalTo(2)));
		assertThat(t3.getValue(), is(equalTo(2)));
		list_fourth_elements.add(t4.getValue());
	//	assertThat(auxBoard.get_tile(3, 0).getValue(), is(equalTo(0)));
		
		//check values of second column
		t1 = auxBoard.get_tile(0, 1);
		t2 = auxBoard.get_tile(1, 1);
		t3 = auxBoard.get_tile(2, 1);
		t4 = auxBoard.get_tile(3, 1);
		assertThat(t1.getValue(), is(equalTo(1)));
		assertThat(t2.getValue(), is(equalTo(3)));
		assertThat(t3.getValue(), is(equalTo(1)));
		list_fourth_elements.add(t4.getValue());
		
		//check values of third column
		t1 = auxBoard.get_tile(0, 2);
		t2 = auxBoard.get_tile(1, 2);
		t3 = auxBoard.get_tile(2, 2);
		t4 = auxBoard.get_tile(3, 2);
		assertThat(t1.getValue(), is(equalTo(6)));
		assertThat(t2.getValue(), is(equalTo(1)));
		assertThat(t3.getValue(), is(equalTo(0)));
		list_fourth_elements.add(t4.getValue());
		
		//check values of fourth column
		t1 = auxBoard.get_tile(0, 3);
		t2 = auxBoard.get_tile(1, 3);
		t3 = auxBoard.get_tile(2, 3);
		t4 = auxBoard.get_tile(3, 3);
		assertThat(t1.getValue(), is(equalTo(0)));
		assertThat(t2.getValue(), is(equalTo(2)));
		assertThat(t3.getValue(), is(equalTo(1)));
		list_fourth_elements.add(t4.getValue());
		assertThat(list_fourth_elements.toArray(), hasItemInArray(0));
	}
	
	@Test
	public void testB1B3(){
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 1);
		board.set_tile(0, 1, 3);
		board.set_tile(0, 2, 6);
		board.set_tile(0, 3, 2);
		
		board.set_tile(1, 0, 1);
		board.set_tile(1, 1, 6);
		board.set_tile(1, 2, 6);
		board.set_tile(1, 3, 0);
		
		board.set_tile(2, 0, 1);
		board.set_tile(2, 1, 12);
		board.set_tile(2, 2, 1);
		board.set_tile(2, 3, 1);
		
		board.set_tile(3, 0, 1);
		board.set_tile(3, 1, 0);
		board.set_tile(3, 2, 1);
		board.set_tile(3, 3, 2);
		
		ThreesController controller = new ThreesController(board);
		assertThat(controller.move_up(), is(equalTo(true)));
		ThreesBoard auxBoard = controller.getBoard();
		
		//check values of first column
		ThreesTile t1 = auxBoard.get_tile(0, 0);
		ThreesTile t2 = auxBoard.get_tile(1, 0);
		ThreesTile t3 = auxBoard.get_tile(2, 0);
		ThreesTile t4 = auxBoard.get_tile(3, 0);
		assertThat(t1.getValue(), is(equalTo(1)));
		assertThat(t2.getValue(), is(equalTo(1)));
		assertThat(t3.getValue(), is(equalTo(1))); 
		assertThat(t4.getValue(), is(equalTo(1)));
		
		//check values of second column
		t1 = auxBoard.get_tile(0, 1);
		t2 = auxBoard.get_tile(1, 1);
		t3 = auxBoard.get_tile(2, 1);
		t4 = auxBoard.get_tile(3, 1);
		assertThat(t1.getValue(), is(equalTo(3)));
		assertThat(t2.getValue(), is(equalTo(6)));
		assertThat(t3.getValue(), is(equalTo(12))); 
		assertThat(t4.getValue(), is(equalTo(0)));
		
		//check values of third column
		t1 = auxBoard.get_tile(0, 2);
		t2 = auxBoard.get_tile(1, 2);
		t3 = auxBoard.get_tile(2, 2);
		t4 = auxBoard.get_tile(3, 2);
		assertThat(t1.getValue(), is(equalTo(12)));
		assertThat(t2.getValue(), is(equalTo(1)));
		assertThat(t3.getValue(), is(equalTo(1))); 
		//assertThat(t4.getValue(), is(equalTo(0)));
		
		//check values of third column
		t1 = auxBoard.get_tile(0, 3);
		t2 = auxBoard.get_tile(1, 3);
		t3 = auxBoard.get_tile(2, 3);
		t4 = auxBoard.get_tile(3, 3);
		assertThat(t1.getValue(), is(equalTo(2)));
		assertThat(t2.getValue(), is(equalTo(1)));
		assertThat(t3.getValue(), is(equalTo(2))); 		
	}
	
	@Test
	public void testB2B1(){
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 1);
		board.set_tile(0, 1, 3);
		board.set_tile(0, 2, 3);
		board.set_tile(0, 3, 3);
		
		board.set_tile(1, 0, 2);
		board.set_tile(1, 1, 3);
		board.set_tile(1, 2, 1);
		board.set_tile(1, 3, 1);
		
		board.set_tile(2, 0, 1);
		board.set_tile(2, 1, 1);
		board.set_tile(2, 2, 3);
		board.set_tile(2, 3, 3);
		
		board.set_tile(3, 0, 1);
		board.set_tile(3, 1, 1);
		board.set_tile(3, 2, 1);
		board.set_tile(3, 3, 1);
		
		ThreesController controller = new ThreesController(board);
		assertThat(controller.move_up(), is(equalTo(true)));
		ThreesBoard auxBoard = controller.getBoard();
		
		//check values of first column
		ThreesTile t1 = auxBoard.get_tile(0, 0);
		ThreesTile t2 = auxBoard.get_tile(1, 0);
		ThreesTile t3 = auxBoard.get_tile(2, 0);
		ThreesTile t4 = auxBoard.get_tile(3, 0);
		assertThat(t1.getValue(), is(equalTo(3)));
		assertThat(t2.getValue(), is(equalTo(1)));
		assertThat(t3.getValue(), is(equalTo(1))); 
		
		//check values of second column
		t1 = auxBoard.get_tile(0, 1);
		t2 = auxBoard.get_tile(1, 1);
		t3 = auxBoard.get_tile(2, 1);
		t4 = auxBoard.get_tile(3, 1);
		assertThat(t1.getValue(), is(equalTo(6)));
		assertThat(t2.getValue(), is(equalTo(1)));
		assertThat(t3.getValue(), is(equalTo(1))); 
		
		//check values of third column
		t1 = auxBoard.get_tile(0, 2);
		t2 = auxBoard.get_tile(1, 2);
		t3 = auxBoard.get_tile(2, 2);
		t4 = auxBoard.get_tile(3, 2);
		assertThat(t1.getValue(), is(equalTo(3)));
		assertThat(t2.getValue(), is(equalTo(1)));
		assertThat(t3.getValue(), is(equalTo(3))); 
		assertThat(t4.getValue(), is(equalTo(1)));
		
		//check values of fourth column
		t1 = auxBoard.get_tile(0, 3);
		t2 = auxBoard.get_tile(1, 3);
		t3 = auxBoard.get_tile(2, 3);
		t4 = auxBoard.get_tile(3, 3);
		assertThat(t1.getValue(), is(equalTo(3)));
		assertThat(t2.getValue(), is(equalTo(1)));
		assertThat(t3.getValue(), is(equalTo(3))); 
		assertThat(t4.getValue(), is(equalTo(1)));
		
	}
	
	@Test
	public void testB3B1(){
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 3);
		board.set_tile(0, 1, 3);
		board.set_tile(0, 2, 6);
		board.set_tile(0, 3, 1);
		
		board.set_tile(1, 0, 1);
		board.set_tile(1, 1, 1);
		board.set_tile(1, 2, 12);
		board.set_tile(1, 3, 1);
		
		board.set_tile(2, 0, 3);
		board.set_tile(2, 1, 6);
		board.set_tile(2, 2, 24);
		board.set_tile(2, 3, 1);
		
		board.set_tile(3, 0, 1);
		board.set_tile(3, 1, 1);
		board.set_tile(3, 2, 48);
		board.set_tile(3, 3, 1);
		
		ThreesController controller = new ThreesController(board);
		assertThat(controller.move_up(), is(equalTo(false)));
		ThreesBoard auxBoard = controller.getBoard();
		
		assertTrue(board.equals(auxBoard));
		
		//check values of first column
		ThreesTile t1 = auxBoard.get_tile(0, 0);
		ThreesTile t2 = auxBoard.get_tile(1, 0);
		ThreesTile t3 = auxBoard.get_tile(2, 0);
		ThreesTile t4 = auxBoard.get_tile(3, 0);
		assertThat(t1.getValue(), is(equalTo(3)));
		assertThat(t2.getValue(), is(equalTo(1)));
		assertThat(t3.getValue(), is(equalTo(3))); 
		assertThat(t4.getValue(), is(equalTo(1)));
		
		//check values of second column
		t1 = auxBoard.get_tile(0, 1);
		t2 = auxBoard.get_tile(1, 1);
		t3 = auxBoard.get_tile(2, 1);
		t4 = auxBoard.get_tile(3, 1);
		assertThat(t1.getValue(), is(equalTo(3)));
		assertThat(t2.getValue(), is(equalTo(1)));
		assertThat(t3.getValue(), is(equalTo(6))); 
		assertThat(t4.getValue(), is(equalTo(1)));
		
		//check values of third column
		t1 = auxBoard.get_tile(0, 2);
		t2 = auxBoard.get_tile(1, 2);
		t3 = auxBoard.get_tile(2, 2);
		t4 = auxBoard.get_tile(3, 2);
		assertThat(t1.getValue(), is(equalTo(6)));
		assertThat(t2.getValue(), is(equalTo(12)));
		assertThat(t3.getValue(), is(equalTo(24))); 
		assertThat(t4.getValue(), is(equalTo(48)));
				
		//check values of fourth column
		t1 = auxBoard.get_tile(0, 3);
		t2 = auxBoard.get_tile(1, 3);
		t3 = auxBoard.get_tile(2, 3);
		t4 = auxBoard.get_tile(3, 3);
		assertThat(t1.getValue(), is(equalTo(1)));
		assertThat(t2.getValue(), is(equalTo(1)));
		assertThat(t3.getValue(), is(equalTo(1))); 
		assertThat(t4.getValue(), is(equalTo(1)));
	}
}
