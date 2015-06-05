package au.com.bgl.command;

import java.io.Serializable;

import au.com.bgl.command.interf.Command;
import au.com.bgl.common.CommonConstants;
import au.com.bgl.interf.Robot;
import au.com.bgl.interf.RobotTable;

public class MoveCommand implements Command, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -3135367800096411110L;

	@Override
	public CommandEnum getCommand() {
		return CommandEnum.MOVE;
	}

	@Override
	public boolean isLegitimateMove(RobotTable robotTable) {
		boolean valid = false;
		Robot robot = robotTable.getRobot();
		if (robot != null) {
			//only work on robot on table.
			switch (robot.getFacing()) {
				case EAST:
					if (robot.getX() < robotTable.getMaxX()) {
						valid = true;
					}
					break;
					
				case NORTH:
					if (robot.getY() < robotTable.getMaxY()) {
						valid = true;
					}
					break;
					
				case WEST:
					if (CommonConstants.ZERO < robot.getX()) {
						valid = true;
					}
					break;
					
				case SOUTH:
					if (CommonConstants.ZERO < robot.getY()) {
						valid = true;
					}
					break;
						
				default:
					valid = false;
			}
		}
		return valid;
	}

	@Override
	public boolean isValidCommand() {
		return true;
	}

}
