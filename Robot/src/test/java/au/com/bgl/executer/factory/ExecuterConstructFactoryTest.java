package au.com.bgl.executer.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.bgl.command.DoNothingCommand;
import au.com.bgl.command.LeftCommand;
import au.com.bgl.command.MoveCommand;
import au.com.bgl.command.PlaceCommand;
import au.com.bgl.command.ReportCommand;
import au.com.bgl.command.RightCommand;
import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.command.interf.ExecuterFactory;
import au.com.bgl.interf.Robot;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ExecuterConstructFactory.class, ExecuterFactory.class, CommandExecuter.class})
public class ExecuterConstructFactoryTest {

	@Test
	public void testFindExecuterFactory() {
		Command command = new DoNothingCommand();
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof DoNothingExecutorFactory);
	}
	
	@Test
	public void testFindExecuterFactoryPlace() {
		Command command = new PlaceCommand(null);
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof PlaceCommandExecuterFactory);
	}
	
	@Test
	public void testFindExecuterFactoryMove() {
		Command command = new MoveCommand();
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof MoveCommandExecuterFactory);
	}
	
	@Test
	public void testFindExecuterFactoryLeft() {
		Command command = new LeftCommand();
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof LeftCommandExecuterFactory);
	}
	
	@Test
	public void testFindExecuterFactoryRight() {
		Command command = new RightCommand();
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof RightCommandExecuterFactory);
	}
	
	@Test
	public void testFindExecuterFactoryReport() {
		Command command = new ReportCommand();
		ExecuterFactory factory = ExecuterConstructFactory.findExecuterFactory(command);
		assertNotNull(factory);
		assertTrue(factory instanceof ReportCommandExecuterFactory);
	}
	
	@Test
	public void testContructExecuter() throws Exception {
		PowerMockito.mockStatic(ExecuterConstructFactory.class);
		PowerMockito.doCallRealMethod().when(ExecuterConstructFactory.class, "contructExecuter", Matchers.any(Command.class), Matchers.any(Robot.class));
		ExecuterFactory mockExecuterFactory = PowerMockito.mock(ExecuterFactory.class);
		PowerMockito.doReturn(mockExecuterFactory).when(ExecuterConstructFactory.class, "findExecuterFactory", Matchers.any(Command.class));
		CommandExecuter mockCommandExecuter = PowerMockito.mock(CommandExecuter.class);
		PowerMockito.doReturn(mockCommandExecuter).when(mockExecuterFactory, "buildExecuter", Matchers.any(Command.class), Matchers.any(Robot.class));
		
		assertEquals(mockCommandExecuter, ExecuterConstructFactory.contructExecuter(null, null));
	}
}
