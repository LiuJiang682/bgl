package au.com.bgl.command;

import au.com.bgl.common.StringUtils;

/**
 * The all valid robot commands.
 * 
 * @author Jiang Liu
 * 
 */
public enum CommandEnum {
	PLACE, MOVE, LEFT, RIGHT, REPORT, DONOTHING;

	public static CommandEnum fromString(final String commandString) {
		if ((!StringUtils.isNullOrEmpty(commandString))
				&& (commandString.toUpperCase().startsWith(PLACE.toString()))) {
			return PLACE;
		}
		
		for (CommandEnum command : CommandEnum.values()) {
			if (command.toString().equalsIgnoreCase(commandString)) {
				return command;
			}
		}

		return DONOTHING;
	}
}
