package test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import threes.ThreesTile;

public class Logic {

	/**
	 * v parameter to test
	 * C1 = (v==0)
	 * C2 = (v==1)
	 * C3 = (v==2)
	 * C4 = (v>2)
	 * C5 = (v mod 3 == 0)
	 * C6 = is_power_of_two(v/3)
	 * */
	
	/**
	 * tomamos como clausula primaria a C1
	 * C2 = F
	 * C3 = F
	 * C4 = F
	 * C5 = V 
	 * C6 = F
	 * */
	@Test
	public void test() {
		ThreesTile t = new ThreesTile();
		int v = 0;
		assertThat(v, not(equalTo(1))); //check c2
		assertThat(v, not(equalTo(2))); //check c3
		assertFalse(v>2); //check c4
		assertThat(v%3 == 0, is(equalTo(true))); //check c5
		assertThat(t.is_power_of_two(v/3), is(equalTo(false))); //check c6
		assertThat(t.is_valid_value(0), is(equalTo(true))); //C1 makes the predicate true
		
		v=-3;
		assertThat(v, not(equalTo(1))); //check c2
		assertThat(v, not(equalTo(2))); //check c3
		assertFalse(v>2); //check c4
		assertThat(v%3 == 0, is(equalTo(true))); //check c5
		assertThat(t.is_power_of_two(v/3), is(equalTo(false))); //check c6
		
		assertThat(t.is_valid_value(-3), is(equalTo(false))); //C1 makes the predicate false
	}
	
	/**
	 * tomamos como clausula primaria a C2
	 * C1 = F
	 * C3 = F
	 * C4 = F
	 * C5 = F
	 * C6 = F
	 * */
	@Test
	public void test1(){
		ThreesTile t = new ThreesTile();
		int v = 1;
		
		assertThat(v, not(equalTo(0))); //check c1
		assertThat(v, not(equalTo(2))); //check c3
		assertFalse(v>2); //check c4
		assertThat(v%3 == 0, is(equalTo(false))); //check c5
		assertThat(t.is_power_of_two(v/3), is(equalTo(false))); //check c6
		assertThat(t.is_valid_value(v), is(equalTo(true))); //C2 makes the predicate true
		
		v=-1;
		assertThat(v, not(equalTo(0))); //check c1
		assertThat(v, not(equalTo(2))); //check c3
		assertFalse(v>2); //check c4
		assertThat(v%3 == 0, is(equalTo(false))); //check c5
		assertThat(t.is_power_of_two(v/3), is(equalTo(false))); //check c6
		assertThat(t.is_valid_value(v), is(equalTo(false))); //C2 makes the predicate false
	}

	/**
	 * tomamos como clausula primaria a C3
	 * C1 = F
	 * C2 = F
	 * C4 = F
	 * C5 = F
	 * C6 = F
	 * */
	@Test
	public void test2(){
		ThreesTile t = new ThreesTile();
		int v = 2;
		
		assertThat(v, not(equalTo(0))); //check c1
		assertThat(v, not(equalTo(1))); //check c2
		assertFalse(v>2); //check c4
		assertThat(v%3 == 0, is(equalTo(false))); //check c5
		assertThat(t.is_power_of_two(v/3), is(equalTo(false))); //check c6
		assertThat(t.is_valid_value(v), is(equalTo(true))); //C2 makes the predicate true
		
		v=-1;
		assertThat(v, not(equalTo(0))); //check c1
		assertThat(v, not(equalTo(1))); //check c2
		assertFalse(v>2); //check c4
		assertThat(v%3 == 0, is(equalTo(false))); //check c5
		assertThat(t.is_power_of_two(v/3), is(equalTo(false))); //check c6
		assertThat(t.is_valid_value(v), is(equalTo(false))); //C2 makes the predicate false
	}
	
	/**
	 * tomamos como clausula primaria a C4
	 * correlacionada
	 * */
	@Test
	public void test3(){
		ThreesTile t = new ThreesTile();
		int v = 12;
		
		assertThat(v, not(equalTo(0))); //check c1
		assertThat(v, not(equalTo(1))); //check c2
		assertThat(v, not(equalTo(2))); //check c3
		assertTrue(v>2); //check c4
		assertThat(v%3 == 0, is(equalTo(true))); //check c5
		assertThat(t.is_power_of_two(v/3), is(equalTo(true))); //check c6
		assertThat(t.is_valid_value(v), is(equalTo(true))); //C2 makes the predicate true
		
		v=-3;
		assertThat(v, not(equalTo(0))); //check c1
		assertThat(v, not(equalTo(1))); //check c2
		assertFalse(v>2); //check c4
		assertThat(v%3 == 0, is(equalTo(true))); //check c5
		assertThat(t.is_power_of_two(v/3), is(equalTo(false))); //check c6
		assertThat(t.is_valid_value(v), is(equalTo(false))); //C2 makes the predicate false
	}
	
	/**
	 * tomamos como clausula primaria a C5 satisface C5 y C6
	 * correlacionada C6 varía
	 * */
	@Test
	public void test4(){
		ThreesTile t = new ThreesTile();
		int v = 12;
		
		assertThat(v, not(equalTo(0))); //check c1
		assertThat(v, not(equalTo(1))); //check c2
		assertThat(v, not(equalTo(2))); //check c3
		assertTrue(v>2); //check c4
		assertThat(v%3 == 0, is(equalTo(true))); //check c5
		assertThat(t.is_power_of_two(v/3), is(equalTo(true))); //check c6
		assertThat(t.is_valid_value(v), is(equalTo(true))); //C2 makes the predicate true
		
		v=10;
		assertThat(v, not(equalTo(0))); //check c1
		assertThat(v, not(equalTo(1))); //check c2
		assertTrue(v>2); //check c4
		assertThat(v%3 == 0, is(equalTo(false))); //check c5
		assertThat(t.is_power_of_two(v/3), is(equalTo(false))); //check c6
		assertThat(t.is_valid_value(v), is(equalTo(false))); //C2 makes the predicate false
	}
	
		
}
