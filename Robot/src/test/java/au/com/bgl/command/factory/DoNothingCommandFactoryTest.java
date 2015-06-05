package au.com.bgl.command.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import au.com.bgl.command.DoNothingCommand;
import au.com.bgl.command.interf.Command;

public class DoNothingCommandFactoryTest {

	private DoNothingCommandFactory instance;
	
	@Before
	public void setUp() {
		this.instance = new DoNothingCommandFactory();
	}
	
	@After
	public void tearDown() {
		this.instance = null;
	}
	
	/**
	 * This test case tests the buildCommand method with
	 * null string.
	 */
	@Test
	public void testBuildCommandNullString() {
		Command command = this.instance.buildCommand(null);
		assertNotNull(command);
		assertTrue(command instanceof DoNothingCommand);
	}
	
	/**
	 * This test case tests the buildCommand method with
	 * null string.
	 */
	@Test
	public void testBuildCommandEmptyString() {
		Command command = this.instance.buildCommand("");
		assertNotNull(command);
		assertTrue(command instanceof DoNothingCommand);
	}
	
	/**
	 * This test case tests the buildCommand method with
	 * null string.
	 */
	@Test
	public void testBuildCommandRubbishString() {
		Command command = this.instance.buildCommand("rubbis");
		assertNotNull(command);
		assertTrue(command instanceof DoNothingCommand);
	}
}
