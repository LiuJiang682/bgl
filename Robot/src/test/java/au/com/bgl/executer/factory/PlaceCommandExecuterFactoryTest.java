package au.com.bgl.executer.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.command.interf.ExecuterFactory;
import au.com.bgl.executer.PlaceCommandExecuter;

public class PlaceCommandExecuterFactoryTest {

	@Test
	public void testBuildExecuter() {
		ExecuterFactory factory = new PlaceCommandExecuterFactory();
		CommandExecuter executer = factory.buildExecuter(null, null);
		assertNotNull(executer);
		assertTrue(executer instanceof PlaceCommandExecuter);
	}
}
