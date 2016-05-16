package test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import threes.AnotherThreesController;
import threes.ThreesBoard;
import threes.ThreesController;

public class BranchTest {

	/**
	 * En esta suite de test intentaremos mejorar el branch coverage,
	 * el cual al medirlo con la suite del ejercicio1 
	 * nos dio que perdiamos 3 branches en la siguiente 
	 * condicion del move_up:
	 * boolean can_combine = !board.get_tile(0, j).isFree() &&
	 *	!board.get_tile(1, j).isFree() &&
	 *	!(board.get_tile(2, j).isFree() && !board.get_tile(3, j).isFree());
	 * */
	
	@Test(timeout=100)
	public void test1() {
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 1);
		board.set_tile(1, 0, 1);
		board.set_tile(2, 0, 0);
		board.set_tile(3, 0, 2);
	
		ThreesController controller = new ThreesController(board);
		assertThat(controller.move_up(), is(equalTo(true)));
	}

	@Test(timeout=100)
	public void test2() {
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 1);
		board.set_tile(1, 0, 1);
		board.set_tile(2, 0, 0);
		board.set_tile(3, 0, 0);
	
		ThreesController controller = new ThreesController(board);
		assertThat(controller.move_up(), is(equalTo(true)));
	}
	
}
