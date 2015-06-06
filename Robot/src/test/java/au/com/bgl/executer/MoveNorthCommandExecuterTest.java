package au.com.bgl.executer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.bgl.BGLRobotTable;
import au.com.bgl.command.interf.Command;
import au.com.bgl.interf.RobotTable;
import au.com.bgl.robot.BGLRobot;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RobotTable.class })
public class MoveNorthCommandExecuterTest {

	@Mock
	private Command mockCommand;

	private MoveNorthCommandExecuter testInstance;
	private BGLRobotTable robotTable;
	private BGLRobot robot;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.testInstance = new MoveNorthCommandExecuter(this.mockCommand);
		this.robot = new BGLRobot();
		this.robotTable = new BGLRobotTable();
		this.robotTable.setRobot(robot);
	}

	@After
	public void tearDown() {
		this.testInstance = null;
		this.robotTable = null;
		this.robot = null;
	}

	@Test
	public void testConstructor() {
		assertNotNull(new MoveNorthCommandExecuter(this.mockCommand));
	}

	@Test
	public void testExecute() {
		givenCommand();
		assertEquals(0, this.robot.getY());

		this.testInstance.execute(robotTable);

		assertEquals(1, this.robot.getY());
	}

	private void givenCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(true);
		when(this.mockCommand.isLegitimateMove(robotTable)).thenReturn(true);
	}

	@Test
	public void testExecuteInvalidCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(false);
		when(this.mockCommand.isLegitimateMove(robotTable)).thenReturn(true);

		assertEquals(0, this.robot.getY());

		this.testInstance.execute(robotTable);

		assertEquals(0, this.robot.getY());
	}
	
	@Test
	public void testExecuteIllegalCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(true);
		when(this.mockCommand.isLegitimateMove(robotTable)).thenReturn(false);

		assertEquals(0, this.robot.getY());

		this.testInstance.execute(robotTable);

		assertEquals(0, this.robot.getY());
	}
	
	@Test
	public void testExecuteInvalidIllegalCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(false);
		when(this.mockCommand.isLegitimateMove(robotTable)).thenReturn(false);

		assertEquals(0, this.robot.getY());

		this.testInstance.execute(robotTable);

		assertEquals(0, this.robot.getY());
	}
}
