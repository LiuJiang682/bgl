package au.com.bgl.command.factory;

import java.io.Serializable;

import au.com.bgl.command.CommandEnum;
import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandFactory;

/**
 * The abstract factory for construct command object.
 * 
 * @author Jiang Liu
 * 
 */
public class CommandConstructFactory implements Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 360894072658242306L;

	private CommandConstructFactory() {
		// prevent instantiation
	}

	public static Command constructCommand(String commandString) {
		CommandFactory commandFactory = findCommandFactory(commandString);
		Command command = commandFactory.buildCommand(commandString);
		return command;
	}

	/**
	 * This method selects the correct command factory.
	 * 
	 * @param commandString
	 *            the command string.
	 * @return command factory object.
	 */
	public static CommandFactory findCommandFactory(String commandString) {

		CommandFactory commandFactory = null;
		switch (CommandEnum.fromString(commandString)) {
		case PLACE:
			commandFactory = new PlaceCommandFactory();
			break;
		case MOVE:
			commandFactory = new MoveCommandFactory();
			break;
		case LEFT:
			commandFactory = new LeftCommandFactory();
			break;
		case RIGHT:
			commandFactory = new RightCommandFactory();
			break;
		case REPORT:
			commandFactory = new ReportCommandFactory();
			break;
		default:
			commandFactory = new DoNothingCommandFactory();
		}

		return commandFactory;
	}
}
