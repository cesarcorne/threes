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
	public void testCanMoveOurMoveUp(@BoardGen(count_boards=10) ThreesBoard b) {
		ThreesController c = new ThreesController(b);
		assumeTrue(c.getBoard().can_move_up());
		assertThat(c.move_up(), is(equalTo(true)));
	}

	@Theory
	public void testCanMoveAnotherMoveUp(@BoardGen(count_boards=10) ThreesBoard b){
		AnotherThreesController c = new AnotherThreesController(b);
		assumeTrue(c.getBoard().can_move_up());
		assertThat(c.move_up(), is(equalTo(true)));
	}
}
