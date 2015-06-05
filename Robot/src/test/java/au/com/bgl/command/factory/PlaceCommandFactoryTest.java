package au.com.bgl.command.factory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import au.com.bgl.command.interf.Command;

public class PlaceCommandFactoryTest {

	private PlaceCommandFactory instance;
	
	@Before
	public void setUp() {
		this.instance = new PlaceCommandFactory();
	}
	
	@After
	public void tearDown() {
		this.instance = null;
	}
	
	//Correct format test
	@Test
	public void testBuildCommand() {
		Command command = this.instance.buildCommand("Place 2, 3, north");
		assertNotNull(command);
		assertTrue(command.isValidCommand());
	}
	
	//Incorrect format test
	@Test
	public void testBuildCommandIncorrectParameter() {
		Command command = this.instance.buildCommand("xx");
		assertNotNull(command);
		assertFalse(command.isValidCommand());
	}
}
