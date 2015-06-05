package au.com.bgl.executer.factory;

import java.io.Serializable;

import au.com.bgl.command.PlaceCommand;
import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.command.interf.ExecuterFactory;
import au.com.bgl.executer.PlaceCommandExecuter;
import au.com.bgl.interf.Robot;

/**
 * The Place command factory class.
 * @author Jiang Liu
 *
 */
public class PlaceCommandExecuterFactory implements ExecuterFactory,
		Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 8551374901096550949L;

	@Override
	public CommandExecuter buildExecuter(Command command, Robot robot) {
		return new PlaceCommandExecuter((PlaceCommand) command);
	}

}
