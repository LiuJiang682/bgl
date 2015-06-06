package au.com.bgl.executer.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.command.interf.ExecuterFactory;
import au.com.bgl.executer.RightCommandExecuter;

public class RightCommandExecuterFactoryTest {

	@Test
	public void testBuildExecuter() {
		ExecuterFactory factory = new RightCommandExecuterFactory();
		CommandExecuter executer = factory.buildExecuter(null, null);
		assertNotNull(executer);
		assertTrue(executer instanceof RightCommandExecuter);
	}
}
