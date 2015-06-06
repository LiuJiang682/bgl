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
public class MoveWestCommandExecuterTest {

	@Mock
	private Command mockCommand;

	private MoveWestCommandExecuter testInstance;
	private BGLRobotTable robotTable;
	private BGLRobot robot;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.testInstance = new MoveWestCommandExecuter(this.mockCommand);
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
		assertNotNull(new MoveWestCommandExecuter(this.mockCommand));
	}

	@Test
	public void testExecute() {
		givenCommand();
		this.robot.setX(3);
		assertEquals(3, this.robot.getX());

		this.testInstance.execute(robotTable);

		assertEquals(2, this.robot.getX());
	}

	private void givenCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(true);
		when(this.mockCommand.isLegitimateMove(robotTable)).thenReturn(true);
	}

	@Test
	public void testExecuteInvalidCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(false);
		when(this.mockCommand.isLegitimateMove(robotTable)).thenReturn(true);

		assertEquals(0, this.robot.getX());

		this.testInstance.execute(robotTable);

		assertEquals(0, this.robot.getX());
	}
	
	@Test
	public void testExecuteIllegalCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(true);
		when(this.mockCommand.isLegitimateMove(robotTable)).thenReturn(false);

		assertEquals(0, this.robot.getX());

		this.testInstance.execute(robotTable);

		assertEquals(0, this.robot.getX());
	}
	
	@Test
	public void testExecuteInvalidIllegalCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(false);
		when(this.mockCommand.isLegitimateMove(robotTable)).thenReturn(false);

		assertEquals(0, this.robot.getX());

		this.testInstance.execute(robotTable);

		assertEquals(0, this.robot.getX());
	}
}
