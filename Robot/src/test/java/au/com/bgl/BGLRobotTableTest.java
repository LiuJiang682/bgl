package au.com.bgl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.bgl.command.factory.CommandConstructFactory;
import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.common.CommonConstants;
import au.com.bgl.executer.factory.ExecuterConstructFactory;
import au.com.bgl.interf.Robot;
import au.com.bgl.interf.RobotTable;

@RunWith(PowerMockRunner.class)
@PrepareForTest({BGLRobotTable.class, ExecuterConstructFactory.class, CommandConstructFactory.class})
public class BGLRobotTableTest {
	
	private BGLRobotTable instance;
	private Scanner scanner;
	
	@Mock
	private CommandExecuter mockExecuter;
	@Mock
	private Robot mockRobot;
	@Mock
	private Command mockCommand;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.instance = PowerMockito.mock(BGLRobotTable.class);
		scanner = new Scanner(System.in);
		PowerMockito.doReturn(scanner).when(this.instance).getScanner();
	}
	
	@After
	public void tearDown() {
		this.instance = null;
		this.scanner = null;
	}

	/**
	 * This test case tests the getNextCommand returns null.
	 * It expected the getRobot method never get call.
	 */
	@Test
	public void testRunWithNullCommandObject() {
		PowerMockito.doReturn(null).when(this.instance).getNextCommand(scanner);
		PowerMockito.doCallRealMethod().when(this.instance).run();
		
		this.instance.run();
		
		Mockito.verify(this.instance, Mockito.never()).getRobot();
	}
	
	/**
	 * This test case tests the getNextCommand returns a command object
	 * with invalid flag set to true. It expected the getRobot method never
	 * get call.
	 */
	@Test
	public void testRunWithInvalidCommand() {
		Mockito.doReturn(false).when(mockCommand).isValidCommand();
		PowerMockito.when(this.instance.getNextCommand(this.scanner)).thenReturn(mockCommand).thenReturn(null);
		Mockito.doCallRealMethod().when(this.instance).run();
		
		this.instance.run();
		
		Mockito.verify(this.instance, Mockito.never()).getRobot();
	}
	
	/**
	 * This test case tests the getNextCommand returns a command object
	 * with legal move flag set to true. It expected the getRobot method 
	 * get call twice.
	 */
	@Test
	public void testRun() {
		PowerMockito.doReturn(true).when(mockCommand).isValidCommand();
		PowerMockito.doReturn(true).when(mockCommand).isLegitimateMove(Matchers.any(RobotTable.class));
		PowerMockito.when(this.instance.getNextCommand(this.scanner)).thenReturn(mockCommand).thenReturn(null);
		
		PowerMockito.doReturn(mockRobot).when(this.instance).getRobot();
		PowerMockito.doReturn(mockExecuter).when(this.instance).getExecuter(Matchers.eq(mockCommand), Matchers.eq(mockRobot));
		
		Mockito.doCallRealMethod().when(this.instance).run();
		
		this.instance.run();
		
		Mockito.verify(this.instance, Mockito.times(CommonConstants.ONE)).getRobot();
		
		ArgumentCaptor<Robot> robotCaptor = ArgumentCaptor.forClass(Robot.class);
		ArgumentCaptor<Command> commandCaptor = ArgumentCaptor.forClass(Command.class);
		Mockito.verify(this.instance).getExecuter(commandCaptor.capture(), robotCaptor.capture());
		List<Robot> captured = robotCaptor.getAllValues();
		assertNotNull(captured);
		assertTrue(captured.size() == CommonConstants.ONE);
		
		List<Command> capturedCommands = commandCaptor.getAllValues();
		assertNotNull(capturedCommands);
		assertTrue(capturedCommands.size() == CommonConstants.ONE);
	}
	
	@Test
	public void testGetScanner() {
		PowerMockito.doCallRealMethod().when(this.instance).getScanner();
		assertNotNull(this.instance.getScanner());
	}
	
	@Test
	public void testGetExecuter() throws Exception {
		PowerMockito.mockStatic(ExecuterConstructFactory.class);
		PowerMockito.doReturn(mockExecuter).when(ExecuterConstructFactory.class, "contructExecuter", Matchers.any(Command.class), Matchers.any(Robot.class));
		PowerMockito.doCallRealMethod().when(this.instance).getExecuter(mockCommand, mockRobot);
		
		assertEquals(this.mockExecuter, this.instance.getExecuter(mockCommand, mockRobot));
	}
	
	@Test
	public void testGetNextCommand() throws Exception {
		Scanner mockScanner = PowerMockito.mock(Scanner.class);
		PowerMockito.doReturn("abc").when(mockScanner).nextLine();
		PowerMockito.mockStatic(CommandConstructFactory.class);
		PowerMockito.doReturn(mockCommand).when(CommandConstructFactory.class, "constructCommand", Matchers.anyString());
		PowerMockito.doCallRealMethod().when(this.instance, "getNextCommand", mockScanner);
		
		assertEquals(mockCommand, this.instance.getNextCommand(mockScanner));
	}
}
