package au.com.bgl.command.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.bgl.command.LeftCommand;
import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandFactory;

public class LeftCommandFactoryTest {

	@Test
	public void testBuildCommand() {
		CommandFactory commandFactory = new LeftCommandFactory();
		Command command = commandFactory.buildCommand(null);
		assertNotNull(command);
		assertTrue(command instanceof LeftCommand);
	}
}
