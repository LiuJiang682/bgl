package au.com.bgl.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import au.com.bgl.command.CommandEnum;

public class CommandEnumTest {

	@Test
	public void testFromString() {
		assertEquals(CommandEnum.DONOTHING, CommandEnum.fromString(null));
		assertEquals(CommandEnum.DONOTHING, CommandEnum.fromString(""));
		assertEquals(CommandEnum.DONOTHING, CommandEnum.fromString("abc"));
		
		assertEquals(CommandEnum.MOVE, CommandEnum.fromString("Move"));
		assertEquals(CommandEnum.LEFT, CommandEnum.fromString("LEFT"));
		assertEquals(CommandEnum.REPORT, CommandEnum.fromString("Report"));
		assertEquals(CommandEnum.RIGHT, CommandEnum.fromString("right"));
	}
	
	@Test
	public void testFromStringMove() {
		assertEquals(CommandEnum.PLACE, CommandEnum.fromString("place"));
		assertEquals(CommandEnum.PLACE, CommandEnum.fromString("PLACE 0,0,NORTH"));
	}
}
