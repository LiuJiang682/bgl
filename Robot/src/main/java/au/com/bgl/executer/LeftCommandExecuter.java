package au.com.bgl.executer;


import java.io.Serializable;
import java.util.HashMap;

import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.directions.Direction;
import au.com.bgl.interf.Robot;
import au.com.bgl.interf.RobotTable;

public class LeftCommandExecuter implements CommandExecuter, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 7480557620793625527L;
	
	private static final HashMap<Direction, Direction> directionMap;
	
	private Command command;
	
	public LeftCommandExecuter(Command command) {
		this.command = command;
	}
	
	@Override
	public void execute(RobotTable robotTable) {
		if ((this.command.isValidCommand())&&(this.command.isLegitimateMove(robotTable))) {
			Robot robot = robotTable.getRobot();
			Direction next = directionMap.get(robot.getFacing());
			robot.setFacing(next);
		}

	}

	static {
		directionMap = new HashMap<Direction, Direction>();
		directionMap.put(Direction.EAST, Direction.NORTH);
		directionMap.put(Direction.NORTH, Direction.WEST);
		directionMap.put(Direction.WEST, Direction.SOUTH);
		directionMap.put(Direction.SOUTH, Direction.EAST);
	}
}
