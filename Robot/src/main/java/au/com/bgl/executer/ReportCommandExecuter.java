package au.com.bgl.executer;

import java.io.Serializable;

import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.interf.Robot;
import au.com.bgl.interf.RobotTable;

public class ReportCommandExecuter implements CommandExecuter, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 4243174115012119781L;

	private Command command;
	
	public ReportCommandExecuter(Command command) {
		this.command = command;
	}
	
	@Override
	public void execute(RobotTable robotTable) {
		if ((this.command.isValidCommand())&&(this.command.isLegitimateMove(robotTable))) {
			Robot robot = robotTable.getRobot();
			System.out.println(robot.getX() + ", " + robot.getY() + ", " + robot.getFacing());
		}
	}

}
