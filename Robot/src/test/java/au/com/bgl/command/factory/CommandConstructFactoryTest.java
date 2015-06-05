package au.com.bgl.command.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandFactory;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CommandConstructFactory.class})
public class CommandConstructFactoryTest {

	/**
	 * This test case tests the constructCommand method.
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testConstructCommand() throws Throwable {
		Command mockCommand = PowerMockito.mock(Command.class);
		CommandFactory mockCommandFactory = PowerMockito.mock(CommandFactory.class);
		PowerMockito.mockStatic(CommandConstructFactory.class);
		PowerMockito.doCallRealMethod().when(CommandConstructFactory.class, "constructCommand", Matchers.anyString());
		PowerMockito.doReturn(mockCommandFactory).when(CommandConstructFactory.class, "findCommandFactory", Matchers.anyString());
		PowerMockito.doReturn(mockCommand).when(mockCommandFactory, "buildCommand", Matchers.anyString());
		Command command = CommandConstructFactory.constructCommand("rubbish");
		assertNotNull(command);
		assertEquals(mockCommand, command);
		
		ArgumentCaptor<String> paramCaptor = ArgumentCaptor.forClass(String.class);
		PowerMockito.verifyStatic();
		CommandConstructFactory.constructCommand(paramCaptor.capture());
		assertEquals("rubbish", paramCaptor.getValue());
	}
	
	/**
	 * This test case tests the findCommandFactory method with null string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithNullString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory(null);
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof DoNothingCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with empty string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithEmptyString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof DoNothingCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with empty string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithRubbishString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("rubbish");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof DoNothingCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with place string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithPlaceString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("place");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof PlaceCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with move string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithMoveString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("move");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof MoveCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with move string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithIncorrectMoveString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("move xx");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof DoNothingCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with left string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithLeftString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("left");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof LeftCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with left string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithIncorrectLeftString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("left xx");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof DoNothingCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with right string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithRightString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("right");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof RightCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with right string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithIncorrectRightString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("right xx");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof DoNothingCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with right string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithReportString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("report");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof ReportCommandFactory);
	}
	
	/**
	 * This test case tests the findCommandFactory method with right string
	 * @throws Throwable
	 */
	@Test
	public void testFindCommandFactoryWithIncorrectReportString() throws Throwable {
		CommandFactory commandFactory = CommandConstructFactory.findCommandFactory("report xx");
		assertNotNull(commandFactory);
		assertTrue(commandFactory instanceof DoNothingCommandFactory);
	}
}
