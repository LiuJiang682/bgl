package au.com.bgl.executer.factory;

import java.io.Serializable;

import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.command.interf.ExecuterFactory;
import au.com.bgl.executer.RightCommandExecuter;
import au.com.bgl.interf.Robot;

public class RightCommandExecuterFactory implements ExecuterFactory,
		Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 2451172349177368383L;

	@Override
	public CommandExecuter buildExecuter(Command command, Robot robot) {
		return new RightCommandExecuter(command);
	}

}
