package au.com.bgl.command;

import java.io.Serializable;

import au.com.bgl.command.interf.Command;
import au.com.bgl.interf.RobotTable;

/**
 * This command class represent an invalid command.
 * @author Jiang Liu
 *
 */
public class DoNothingCommand implements Command, Serializable {

	/**
	 * Generated Serial Version UID. 
	 */
	private static final long serialVersionUID = 1964175925281378081L;

	@Override
	public CommandEnum getCommand() {	
		return CommandEnum.DONOTHING;
	}

	@Override
	public boolean isLegitimateMove(RobotTable robotTable) {
		return false;
	}

	@Override
	public boolean isValidCommand() {
		return false;
	}

}
