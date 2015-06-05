package au.com.bgl.command;

import java.io.Serializable;

import au.com.bgl.command.interf.Command;
import au.com.bgl.common.CommonConstants;
import au.com.bgl.directions.Direction;
import au.com.bgl.interf.RobotTable;

public class PlaceCommand implements Command, Serializable {

	/**
	 * Generated Serial Version UID. 
	 */
	private static final long serialVersionUID = 7705090543914283008L;

	private int x;
	private int y;
	private Direction facing;
	private boolean valid;
	private String orginal;
	
	// Constructor for invalid command.
	public PlaceCommand(String commandString) {
		this.orginal = commandString;
		this.valid = false;
	}
	
	// Constructor for correct format place command
	public PlaceCommand(String commandString, String paramString) {
		this.orginal = commandString;
		
		String[] params = paramString.split(CommonConstants.PARAM_DELIM);
		if ((params == null)||(params.length != CommonConstants.THREE)) {
			// The parameter string is not in correct format,
			// set the valid flag to false.
			this.valid = false;
		} else {
			try {
				this.x = Integer.parseInt(params[CommonConstants.ZERO].trim());
				this.y = Integer.parseInt(params[CommonConstants.ONE].trim());
			} catch (NumberFormatException e) {
				// Cannot convert to x and y, 
				// set the valid flag to false.
				this.valid = false;
				return;
			}
			
			// Do facing convention
			try {
				this.facing = Direction.valueOf(params[CommonConstants.TWO].trim().toUpperCase());
				this.valid = true;
			} catch (Exception e) {
				e.printStackTrace();
				// Cannot convent to facing
				// set the valid flag to false
				this.valid = false;
			}
		}
	}
	
	@Override
	public CommandEnum getCommand() {
		return CommandEnum.PLACE;
	}

	@Override
	public boolean isLegitimateMove(RobotTable robotTable) {
		boolean valid = false;
		if ((CommonConstants.ZERO <= getX())&&(getX() <= robotTable.getMaxX())) {
			if ((CommonConstants.ZERO <= getY())&&(getY() <= robotTable.getMaxY())) {
				valid = true;
			}
		}
		return valid;
	}

	@Override
	public boolean isValidCommand() {
		return this.valid;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direction getFacing() {
		return facing;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(this.orginal);
		sb.append(", valid ");
		sb.append(this.valid);
		return sb.toString();
	}
}
