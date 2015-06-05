package au.com.bgl.command.interf;

import au.com.bgl.command.CommandEnum;
import au.com.bgl.interf.RobotTable;

/**
 * The command interface for robot.
 * 
 * @author Jiang Liu
 *
 */
public interface Command {

	boolean isValidCommand();
	
	boolean isLegitimateMove(RobotTable robotTable);
	
	CommandEnum getCommand();
}
