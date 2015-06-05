package au.com.bgl.executer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.bgl.command.PlaceCommand;
import au.com.bgl.common.CommonConstants;
import au.com.bgl.directions.Direction;
import au.com.bgl.interf.Robot;
import au.com.bgl.interf.RobotTable;
import au.com.bgl.robot.BGLRobot;

@RunWith(PowerMockRunner.class)
@PrepareForTest({RobotTable.class})
public class PlaceCommandExecuterTest {

	private PlaceCommandExecuter instance;
	
	@Before
	public void setUp() {
		PlaceCommand placeCommand = new PlaceCommand("place 2, 3, north", "2, 3, north");
		this.instance = new PlaceCommandExecuter(placeCommand);
	}
	
	@After
	public void tearDown() {
		this.instance = null;
	}
	
	/**
	 * This test case tests the first time place command execute.
	 */
	@Test
	public void testExecuteAsFirtTime() {
		RobotTable mockRobotTable = PowerMockito.mock(RobotTable.class);
		PowerMockito.doReturn(5).when(mockRobotTable).getMaxX();
		PowerMockito.doReturn(5).when(mockRobotTable).getMaxY();
		this.instance.execute(mockRobotTable);
		
		ArgumentCaptor<Robot> robotCaptor = ArgumentCaptor.forClass(Robot.class);
		Mockito.verify(mockRobotTable).setRobot(robotCaptor.capture());
		List<Robot> allcaptured = robotCaptor.getAllValues();
		assertNotNull(allcaptured);
		assertTrue(allcaptured.size() == CommonConstants.ONE);
	}
	
	/**
	 * This test case tests the first time place command execute.
	 * @throws Throwable 
	 */
	@Test
	public void testExecute() throws Throwable {
		RobotTable mockRobotTable = PowerMockito.mock(RobotTable.class);
		PowerMockito.doReturn(5).when(mockRobotTable).getMaxX();
		PowerMockito.doReturn(5).when(mockRobotTable).getMaxY();
		Robot robot = new BGLRobot();
		PowerMockito.doReturn(robot ).when(mockRobotTable, "getRobot");
		this.instance.execute(mockRobotTable);
		
		assertEquals(2, robot.getX());
		assertEquals(3, robot.getY());
		assertEquals(Direction.NORTH, robot.getFacing());
	}
}
