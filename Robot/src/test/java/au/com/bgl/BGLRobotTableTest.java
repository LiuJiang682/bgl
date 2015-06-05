package au.com.bgl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.common.CommonConstants;
import au.com.bgl.interf.Robot;
import au.com.bgl.interf.RobotTable;

@RunWith(PowerMockRunner.class)
@PrepareForTest({BGLRobotTable.class})
public class BGLRobotTableTest {
	
	private BGLRobotTable instance;
	private Scanner scanner;
	
	@Before
	public void setUp() {
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
		Command mockCommand = Mockito.mock(Command.class);
		Mockito.doReturn(false).when(mockCommand).isValidCommand();
		PowerMockito.when(this.instance.getNextCommand(this.scanner)).thenReturn(mockCommand).thenReturn(null);
		Mockito.doCallRealMethod().when(this.instance).run();
		
		this.instance.run();
		
		Mockito.verify(this.instance, Mockito.never()).getRobot();
	}
	
	/**
	 * This test case tests the getNextCommand returns a command object
	 * with illegal move flag set to true. It expected the getRobot method never
	 * get call.
	 */
	@Ignore
	@Test
	public void testRunWithIllegalMove() {
		Command mockCommand = PowerMockito.mock(Command.class);
		PowerMockito.doReturn(true).when(mockCommand).isValidCommand();
		PowerMockito.doReturn(false).when(mockCommand).isLegitimateMove(Matchers.any(RobotTable.class));
		PowerMockito.when(this.instance.getNextCommand(this.scanner)).thenReturn(mockCommand).thenReturn(null);
		Mockito.doCallRealMethod().when(this.instance).run();
		
		this.instance.run();
		
		Mockito.verify(this.instance, Mockito.times(CommonConstants.ONE)).getRobot();
		
		ArgumentCaptor<RobotTable> robotCaptor = ArgumentCaptor.forClass(RobotTable.class);
		Mockito.verify(mockCommand).isLegitimateMove(robotCaptor.capture());
		List<RobotTable> captured = robotCaptor.getAllValues();
		assertNotNull(captured);
		assertTrue(captured.size() == CommonConstants.ONE);
	}
	
	/**
	 * This test case tests the getNextCommand returns a command object
	 * with legal move flag set to true. It expected the getRobot method 
	 * get call twice.
	 */
	@Test
	public void testRun() {
		Command mockCommand = PowerMockito.mock(Command.class);
		PowerMockito.doReturn(true).when(mockCommand).isValidCommand();
		PowerMockito.doReturn(true).when(mockCommand).isLegitimateMove(Matchers.any(RobotTable.class));
		PowerMockito.when(this.instance.getNextCommand(this.scanner)).thenReturn(mockCommand).thenReturn(null);
		
		Robot mockRobot = PowerMockito.mock(Robot.class);
		PowerMockito.doReturn(mockRobot).when(this.instance).getRobot();
		CommandExecuter mockExecuter = PowerMockito.mock(CommandExecuter.class);
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
}
