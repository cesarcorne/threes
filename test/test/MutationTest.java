package test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

import org.junit.Test;

import threes.ThreesBoard;
import threes.ThreesController;
import threes.ThreesTile;

public class MutationTest {

	@Test(timeout=100)
	public void testCanCombineTwice() {
		ThreesBoard board = new ThreesBoard();
		
		board.set_tile(0, 0, 3);
		board.set_tile(1, 0, 3);
		board.set_tile(2, 0, 3);
		board.set_tile(3, 0, 3);
		ThreesController controller = new ThreesController(board);
		assertThat(controller.move_up(), is(equalTo(true)));
		
		ThreesBoard auxBoard = controller.getBoard();

		//check the first column
		ThreesTile t1 = auxBoard.get_tile(0, 0);
		ThreesTile t2 = auxBoard.get_tile(1, 0);
		ThreesTile t3 = auxBoard.get_tile(2, 0);
		//ThreesTile t4 = auxBoard.get_tile(3, 0);
		assertThat(t1.getValue(), is(equalTo(6)));
		assertThat(t2.getValue(), is(equalTo(3)));
		assertThat(t3.getValue(), is(equalTo(3)));
		//assertThat(t4.getValue(), is(equalTo(0)));
	}
	
	@Test(timeout=100)
	public void testNewTile(){
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 1);
		board.set_tile(0, 1, 1);
		board.set_tile(0, 2, 1);
		board.set_tile(0, 3, 1);
		
		board.set_tile(1, 0, 1);
		board.set_tile(1, 1, 1);
		board.set_tile(1, 2, 2);
		board.set_tile(1, 3, 1);
		
		board.set_tile(2, 0, 1);
		board.set_tile(2, 1, 1);
		board.set_tile(2, 2, 1);
		board.set_tile(2, 3, 1);
		
		board.set_tile(3, 0, 1);
		board.set_tile(3, 1, 1);
		board.set_tile(3, 2, 1);
		board.set_tile(3, 3, 1);
		
		ThreesController controller = new ThreesController(board);
		assertThat(controller.move_up(), is(equalTo(true)));
		assertThat(controller.getBoard().get_tile(3, 2).getValue(), not(equalTo(0)));
		assertThat(controller.getBoard().get_tile(3, 0).getValue(), is(equalTo(1)));
		assertThat(controller.getBoard().get_tile(3, 1).getValue(), is(equalTo(1)));
		assertThat(controller.getBoard().get_tile(3, 3).getValue(), is(equalTo(1)));
	}

}
