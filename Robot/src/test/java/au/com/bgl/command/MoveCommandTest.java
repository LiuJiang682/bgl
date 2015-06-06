package au.com.bgl.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import au.com.bgl.directions.Direction;
import au.com.bgl.interf.Robot;
import au.com.bgl.interf.RobotTable;

public class MoveCommandTest {

	private MoveCommand testInstance;
	
	@Mock
	private RobotTable mockRobotTable;
	@Mock
	private Robot mockRobot;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.testInstance = new MoveCommand();
	}
	
	@After
	public void tearDown() {
		this.testInstance = null;
	}
	
	@Test
	public void testGetCommand() {
		assertEquals(CommandEnum.MOVE, this.testInstance.getCommand());
	}
	
	@Test
	public void testIsValid() {
		assertTrue(this.testInstance.isValidCommand());
	}
	
	@Test
	public void testIsLegitimateMoveNullRobot() {
		assertFalse(this.testInstance.isLegitimateMove(mockRobotTable));
	}
	
	@Test
	public void testIsLegitimateMoveEast() {
		when(mockRobotTable.getRobot()).thenReturn(mockRobot);
		when(mockRobotTable.getMaxX()).thenReturn(5);
		when(mockRobot.getFacing()).thenReturn(Direction.EAST);
		when(mockRobot.getX()).thenReturn(0);
		assertTrue(this.testInstance.isLegitimateMove(mockRobotTable));
	}
	
	@Test
	public void testIsLegitimateMoveEastFalse() {
		when(mockRobotTable.getRobot()).thenReturn(mockRobot);
		when(mockRobotTable.getMaxX()).thenReturn(5);
		when(mockRobot.getFacing()).thenReturn(Direction.EAST);
		when(mockRobot.getX()).thenReturn(5);
		assertFalse(this.testInstance.isLegitimateMove(mockRobotTable));
	}
	
	@Test
	public void testIsLegitimateMoveNorth() {
		when(mockRobotTable.getRobot()).thenReturn(mockRobot);
		when(mockRobotTable.getMaxY()).thenReturn(5);
		when(mockRobot.getFacing()).thenReturn(Direction.NORTH);
		when(mockRobot.getY()).thenReturn(0);
		assertTrue(this.testInstance.isLegitimateMove(mockRobotTable));
	}
	
	@Test
	public void testIsLegitimateMoveNorthFail() {
		when(mockRobotTable.getRobot()).thenReturn(mockRobot);
		when(mockRobotTable.getMaxY()).thenReturn(5);
		when(mockRobot.getFacing()).thenReturn(Direction.EAST);
		when(mockRobot.getY()).thenReturn(5);
		assertFalse(this.testInstance.isLegitimateMove(mockRobotTable));
	}
	
	@Test
	public void testIsLegitimateMoveWest() {
		when(mockRobotTable.getRobot()).thenReturn(mockRobot);
		when(mockRobot.getFacing()).thenReturn(Direction.WEST);
		when(mockRobot.getX()).thenReturn(1);
		assertTrue(this.testInstance.isLegitimateMove(mockRobotTable));
	}
	
	@Test
	public void testIsLegitimateMoveWestFalse() {
		when(mockRobotTable.getRobot()).thenReturn(mockRobot);
		when(mockRobot.getFacing()).thenReturn(Direction.WEST);
		when(mockRobot.getX()).thenReturn(0);
		assertFalse(this.testInstance.isLegitimateMove(mockRobotTable));
	}
	
	@Test
	public void testIsLegitimateMoveSouth() {
		when(mockRobotTable.getRobot()).thenReturn(mockRobot);
		when(mockRobot.getFacing()).thenReturn(Direction.SOUTH);
		when(mockRobot.getY()).thenReturn(1);
		assertTrue(this.testInstance.isLegitimateMove(mockRobotTable));
	}
	
	@Test
	public void testIsLegitimateMoveSouthFalse() {
		when(mockRobotTable.getRobot()).thenReturn(mockRobot);
		when(mockRobot.getFacing()).thenReturn(Direction.SOUTH);
		when(mockRobot.getY()).thenReturn(0);
		assertFalse(this.testInstance.isLegitimateMove(mockRobotTable));
	}
}
