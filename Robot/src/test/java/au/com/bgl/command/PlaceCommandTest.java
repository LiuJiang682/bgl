package au.com.bgl.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import au.com.bgl.BGLRobotTable;
import au.com.bgl.directions.Direction;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Direction.class})
public class PlaceCommandTest {

	/**
	 * This test case tests the rubbish string
	 * constructor.
	 */
	@Test
	public void testInvalidCommandConstructor() {
		PlaceCommand command = new PlaceCommand("rubbish");
		assertEquals(CommandEnum.PLACE, command.getCommand());
		assertFalse(command.isValidCommand());
	}
	
	/**
	 * This test case tests the string with rubbish parameter string
	 */
	@Test
	public void testConstructorWithRubbishParam() {
		PlaceCommand command = new PlaceCommand("rubbish rubbish", "rubbish");
		assertEquals(CommandEnum.PLACE, command.getCommand());
		assertFalse(command.isValidCommand());
	}
	
	/**
	 * This test case tests the string with character x, y parameter string
	 */
	@Test
	public void testConstructorWithRubbishXYParam() {
		PowerMockito.mockStatic(Direction.class);
		
		PlaceCommand command = new PlaceCommand("place x, y, f", "x, y, f");
		assertEquals(CommandEnum.PLACE, command.getCommand());
		assertFalse(command.isValidCommand());
		
		PowerMockito.verifyStatic(Mockito.never());
		Direction.valueOf(Matchers.anyString());
	}
	
	/**
	 * This test case tests the string with character x, y parameter string
	 */
	@Test
	public void testConstructorWithEmptyXYParam() {
		PowerMockito.mockStatic(Direction.class);
		
		PlaceCommand command = new PlaceCommand("place , , f", ", , f");
		assertEquals(CommandEnum.PLACE, command.getCommand());
		assertFalse(command.isValidCommand());
		
		PowerMockito.verifyStatic(Mockito.never());
		Direction.valueOf(Matchers.anyString());
	}
	
	/**
	 * This test case tests the string with character x, y parameter string
	 */
	@Test
	public void testConstructorWithRubbishYParam() {
		PowerMockito.mockStatic(Direction.class);
		
		PlaceCommand command = new PlaceCommand("place 2, y, f", "2, y, f");
		assertEquals(CommandEnum.PLACE, command.getCommand());
		assertFalse(command.isValidCommand());
		
		PowerMockito.verifyStatic(Mockito.never());
		Direction.valueOf(Matchers.anyString());
	}
	
	/**
	 * This test case tests the string with incorrect facing parameter string
	 */
	@Test
	public void testConstructorWithRubbishFacingParam() {

		PlaceCommand command = new PlaceCommand("place 2, 3, f", "2, 3, f");
		assertEquals(CommandEnum.PLACE, command.getCommand());
		assertFalse(command.isValidCommand());
		
	}
	
	/**
	 * This test case tests the string with character x, y parameter string
	 */
	@Test
	public void testConstructor() {

		PlaceCommand command = new PlaceCommand("place 2, 3, north", "2, 3, north");
		assertEquals(CommandEnum.PLACE, command.getCommand());
		assertTrue(command.isValidCommand());
	}
	
	/**
	 * This test case tests the isLegitimateMove flag.
	 */
	@Test
	public void testIsLegitimateMove() {
		PlaceCommand command = new PlaceCommand("place 2, 3, north", "2, 3, north");
		BGLRobotTable table = new BGLRobotTable();
		assertTrue(command.isLegitimateMove(table));
	}
	
	/**
	 * This test case tests the isLegitimateMove flag.
	 */
	@Test
	public void testIsLegitimateMoveFail() {
		PlaceCommand command = new PlaceCommand("place 7, 7, north", "7, 7, north");
		BGLRobotTable table = new BGLRobotTable();
		assertFalse(command.isLegitimateMove(table));
	}
}
