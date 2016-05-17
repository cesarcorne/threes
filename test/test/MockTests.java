package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import static org.easymock.EasyMock.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.Map;

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
	
	/**
	 * Test que chequea el metodo SaveGame mediante un caso en el cual es válido guardar
	 * */
	@Test
	public void testCorrectSaveGame() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego";
		expect(manager.setFolder(folderName)).andReturn(true);
		expect(manager.saveToFile(controller.getBoard(), controller.getNextTileValue(), fileName + ".ths")).andReturn(true);
		replay(manager);
		
		assertThat(controller.saveGame(folderName, fileName), is(equalTo(true)));
	}

	/**
	 * Test que chequea el metodo SaveGame mediante un caso en el cual
	 * no es válido guardar, ya que esta mal el nombre de archivo dado
	 * */
	@Test
	public void testBadFileNameSaveGame() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego.ths";
		expect(manager.setFolder(folderName)).andReturn(true);
		replay(manager);
		
		assertThat(controller.saveGame(folderName, fileName), is(equalTo(false)));
	}
	
	/**
	 * Test que chequea el metodo SaveGame mediante un caso en el cual
	 * no es válido guardar, ya que la carpeta seleccionada no es válida
	 * */
	@Test
	public void testUnexistedFolderSaveGame() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego.ths";
		expect(manager.setFolder(folderName)).andReturn(false);
		replay(manager);
		
		assertThat(controller.saveGame(folderName, fileName), is(equalTo(false)));
	}
	
	/**
	 * Test que chequea el metodo SaveGame mediante un caso en el cual 
	 * setFolder del mock nos retorna una IOException
	 * */
	@Test
	public void testSetFolderIOExceptionSaveGame() throws IOException  {
		String folderName = "carpeta";
		String fileName = "mijuego";
		IOException e = new IOException();
		expect(manager.setFolder(folderName)).andThrow(e);
		replay(manager);
		controller.saveGame(folderName, fileName);
		verify(manager);
	}
	
	/**
	 * Test que chequea el metodo LoadGame mediante un caso en el cual
	 * no es válido cargar un juego, ya que la carpeta dada no es correcta
	 * */
	@Test
	public void testUnexistedFolderToLoad() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego.ths";
		
		expect(manager.setFolder(folderName)).andReturn(false);
		
		replay(manager);
		assertThat(controller.loadGame(folderName, fileName), is(equalTo(false)));
	}
	
	/**
	 * Test que chequea el metodo LoadGame mediante un caso en el cual
	 * no es válido cargar un juego, ya que el archivo dado no es correcto
	 * */
	@Test
	public void testBadFileNameLoad() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego";
		
		expect(manager.setFolder(folderName)).andReturn(true);
		
		replay(manager);
		assertThat(controller.loadGame(folderName, fileName), is(equalTo(false)));
	}
	
	/**
	 * Test que chequea el metodo LoadGame mediante un caso en el cual
	 * no es válido cargar un juego, ya que el mismo es null
	 * */
	@Test
	public void testNullFileLoadGame() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego.ths";
		
		expect(manager.setFolder(folderName)).andReturn(true);
		expect(manager.loadFromFile(fileName)).andReturn(null);
		replay(manager);
		controller.loadGame(folderName, fileName);
		verify(manager);
	}
	
	/**
	 * Test que chequea el metodo LoadGame mediante un caso en el cual
	 * LoadFromFile del mock nos retorna una IOException
	 * */
	@Test
	public void testIOExceptionOnLoadFromFile() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego.ths";
		expect(manager.setFolder(folderName)).andReturn(true);
		IOException e = new IOException();
		expect(manager.loadFromFile(fileName)).andThrow(e);
		replay(manager);
		controller.loadGame(folderName, fileName);
		verify(manager);
	}
	
	/**
	 * Test que chequea el metodo LoadGame mediante un caso en el cual
	 * es válido cargar un juego y el mismo no es null
	 * */
	@Test
	public void testCorrectLoadGame() throws IOException {
		String folderName = "carpeta";
		String fileName = "mijuego.ths";
		HashMap<ThreesBoard, Integer> map = new HashMap<ThreesBoard, Integer>();

		map.put(controller.getBoard(), controller.getNextTileValue());
		Map.Entry<ThreesBoard, Integer> a = (Map.Entry<ThreesBoard, Integer>) map.entrySet().iterator().next();
		
		expect(manager.setFolder(folderName)).andReturn(true);
		expect(manager.loadFromFile(fileName)).andReturn(a);
		
		replay(manager);
		
		assertThat(controller.loadGame(folderName, fileName), is(equalTo(true)));
		
		verify(manager);
		
	}
	
	
}
