package au.com.bgl.command.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.bgl.command.RightCommand;
import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandFactory;

public class RightCommandFactoryTest {

	@Test
	public void testBuildCommand() {
		CommandFactory commandFactory = new RightCommandFactory();
		Command command = commandFactory.buildCommand(null);
		assertNotNull(command);
		assertTrue(command instanceof RightCommand);
	}
}
