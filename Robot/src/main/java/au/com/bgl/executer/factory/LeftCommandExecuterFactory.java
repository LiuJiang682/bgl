package au.com.bgl.executer.factory;

import java.io.Serializable;

import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.command.interf.ExecuterFactory;
import au.com.bgl.executer.LeftCommandExecuter;
import au.com.bgl.interf.Robot;

public class LeftCommandExecuterFactory implements ExecuterFactory,
		Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -2116161501346490872L;

	@Override
	public CommandExecuter buildExecuter(Command command, Robot robot) {
		return new LeftCommandExecuter(command);
	}

}
