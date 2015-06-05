package au.com.bgl.executer;

import java.io.Serializable;

import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.interf.Robot;
import au.com.bgl.interf.RobotTable;

public class MoveNorthCommandExecuter implements CommandExecuter, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -2860515768804752231L;

	private Command command;
	
	public MoveNorthCommandExecuter(Command command) {
		this.command = command;
	}
	
	@Override
	public void execute(RobotTable robotTable) {
		if ((this.command.isValidCommand())&&(this.command.isLegitimateMove(robotTable))) {
			Robot robot = robotTable.getRobot();
			int y = robot.getY();
			++y;
			robot.setY(y);
		}

	}

}
