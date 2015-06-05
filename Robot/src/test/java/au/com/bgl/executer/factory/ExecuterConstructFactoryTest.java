package au.com.bgl.executer.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.bgl.command.DoNothingCommand;
import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.ExecuterFactory;

public class ExecuterConstructFactoryTest {

	@Test
	public void testFindExecuterFactory() {
		Command command = new DoNothingCommand();
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof DoNothingExecutorFactory);
	}
}
