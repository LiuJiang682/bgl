package au.com.bgl.command;

/**
 * The all valid robot commands.
 * 
 * @author Jiang Liu
 *
 */
public enum CommandEnum {
	PLACE, MOVE, LEFT, RIGHT, REPORT, DONOTHING;
	
	public static CommandEnum fromString(final String commandString) {
		for (CommandEnum command : CommandEnum.values()) {
			if (command.toString().equalsIgnoreCase(commandString)) {
				return command;
			}
		}
		
		return DONOTHING;
	}
}
