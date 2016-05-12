package test;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import threes.ISaveManager;
import threes.ThreesBoard;
import threes.ThreesController;

public class MockTests {

	ThreesController controller;
	ISaveManager manager;
	
	@Before
	public void set_up(){
		manager = createStrictMock(ISaveManager.class);
		controller = new ThreesController();
		controller.setSaveManager(manager);
	}
	
	@Test
	public void test() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego";
		expect(manager.setFolder(folderName)).andReturn(true);
		expect(manager.saveToFile(controller.getBoard(), controller.getNextTileValue(), fileName + ".ths")).andReturn(true);
		replay(manager);
		
		assertThat(controller.saveGame(folderName, fileName), is(equalTo(true)));
	}

	@Test
	public void test1() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego.ths";
		expect(manager.setFolder(folderName)).andReturn(true);
	//	expect(manager.saveToFile(controller.getBoard(), controller.getNextTileValue(), fileName)).andReturn(false);
		replay(manager);
		
		assertThat(controller.saveGame(folderName, fileName), is(equalTo(false)));
	}
	
	@Test
	public void test2() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego.ths";
		expect(manager.setFolder(folderName)).andReturn(false);
	//	expect(manager.saveToFile(controller.getBoard(), controller.getNextTileValue(), fileName)).andReturn(false);
		replay(manager);
		
		assertThat(controller.saveGame(folderName, fileName), is(equalTo(false)));
	}
	
	@Test//(expected=IOException.class)
	public void test3() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego";
		IOException e = new IOException();
		expect(manager.setFolder(folderName)).andThrow(e);
		replay(manager);
		controller.saveGame(folderName, fileName);
		//verify(manager);
	}
	
	@Test
	public void test4() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego.ths";
		
		expect(manager.setFolder(folderName)).andReturn(false);
		
		replay(manager);
		assertThat(controller.loadGame(folderName, fileName), is(equalTo(false)));
	}
	
	@Test
	public void test5() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego";
		
		expect(manager.setFolder(folderName)).andReturn(true);
		
		replay(manager);
		assertThat(controller.loadGame(folderName, fileName), is(equalTo(false)));
	}
	
	@Test
	public void test6() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego.ths";
		
		expect(manager.setFolder(folderName)).andReturn(true);
		expect(manager.loadFromFile(fileName)).andReturn(null);
		replay(manager);
		controller.loadGame(folderName, fileName);
		verify(manager);
	}
	
	@Test
	public void test7() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego.ths";
		expect(manager.setFolder(folderName)).andReturn(true);
		IOException e = new IOException();
		expect(manager.loadFromFile(fileName)).andThrow(e);
		replay(manager);
		controller.loadGame(folderName, fileName);
		verify(manager);
	}
	
	@Test(expected = NullPointerException.class)
	public void test8() throws IOException {
		String folderName = "carpeta";
		String fileName = null;
		expect(manager.setFolder(folderName)).andReturn(true);
		IOException e = new IOException();
		expect(manager.loadFromFile(fileName)).andThrow(e);
		replay(manager);
		controller.loadGame(folderName, fileName);
		verify(manager);
	}
}
