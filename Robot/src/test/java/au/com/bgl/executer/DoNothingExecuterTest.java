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
import au.com.bgl.directions.Direction;
import au.com.bgl.interf.RobotTable;
import au.com.bgl.robot.BGLRobot;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RobotTable.class })
public class DoNothingExecuterTest {

	@Mock
	private Command mockCommand;

	private DoNothingExecuter testInstance;
	private BGLRobotTable robotTable;
	private BGLRobot robot;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.testInstance = new DoNothingExecuter();
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
		assertNotNull(new DoNothingExecuter());
	}

	@Test
	public void testExecuteEast() {
		givenCommand();
		this.robot.setFacing(Direction.EAST);

		this.testInstance.execute(robotTable);

		assertEquals(Direction.EAST, this.robot.getFacing());
	}

	private void givenCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(true);
		when(this.mockCommand.isLegitimateMove(robotTable)).thenReturn(true);
	}

	@Test
	public void testExecuteNorth() {
		givenCommand();
		this.robot.setFacing(Direction.NORTH);

		this.testInstance.execute(robotTable);

		assertEquals(Direction.NORTH, this.robot.getFacing());
	}

	@Test
	public void testExecuteWest() {
		givenCommand();
		this.robot.setFacing(Direction.WEST);

		this.testInstance.execute(robotTable);

		assertEquals(Direction.WEST, this.robot.getFacing());
	}

	@Test
	public void testExecuteSouth() {
		givenCommand();
		this.robot.setFacing(Direction.SOUTH);

		this.testInstance.execute(robotTable);

		assertEquals(Direction.SOUTH, this.robot.getFacing());
	}

	@Test
	public void testExecuteInvalidCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(false);
		when(this.mockCommand.isLegitimateMove(robotTable)).thenReturn(true);

		this.robot.setFacing(Direction.SOUTH);

		this.testInstance.execute(robotTable);

		assertEquals(Direction.SOUTH, this.robot.getFacing());
	}
	
	@Test
	public void testExecuteIllegalCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(true);
		when(this.mockCommand.isLegitimateMove(robotTable)).thenReturn(false);

		this.robot.setFacing(Direction.SOUTH);

		this.testInstance.execute(robotTable);

		assertEquals(Direction.SOUTH, this.robot.getFacing());
	}
	
	@Test
	public void testExecuteInvalidIllegalCommand() {
		when(this.mockCommand.isValidCommand()).thenReturn(false);
		when(this.mockCommand.isLegitimateMove(robotTable)).thenReturn(false);

		this.robot.setFacing(Direction.SOUTH);

		this.testInstance.execute(robotTable);

		assertEquals(Direction.SOUTH, this.robot.getFacing());
	}
}
