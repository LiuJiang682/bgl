package au.com.bgl.executer;

import java.io.Serializable;

import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.interf.Robot;
import au.com.bgl.interf.RobotTable;

/**
 * Move command executer.
 * @author Jiang Liu
 *
 */
public class MoveEastCommandExecuter implements CommandExecuter, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 775919649771492709L;

	private Command command;
	
	public MoveEastCommandExecuter(Command command) {
		this.command = command;
	}
	
	@Override
	public void execute(RobotTable robotTable) {
		if ((this.command.isValidCommand())&&(this.command.isLegitimateMove(robotTable))) {
			Robot robot = robotTable.getRobot();
			int x = robot.getX();
			++x;
			robot.setX(x);
		}

	}

}
