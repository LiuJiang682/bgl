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

import au.com.bgl.interf.Robot;
import au.com.bgl.interf.RobotTable;

public class RightCommandTest {

	private RightCommand testInstance;
	
	@Mock
	private RobotTable mockRobotTable;
	@Mock
	private Robot mockRobot;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.testInstance = new RightCommand();
	}
	
	@After
	public void tearDown() {
		this.testInstance = null;
	}

	@Test
	public void testGetCommand() {
		assertEquals(CommandEnum.RIGHT, this.testInstance.getCommand());
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
	public void testIsLegitimateMove() {
		when(this.mockRobotTable.getRobot()).thenReturn(mockRobot);
		assertTrue(this.testInstance.isLegitimateMove(mockRobotTable));
	}
}
