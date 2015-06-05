package au.com.bgl.executer.factory;

import java.io.Serializable;

import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.command.interf.ExecuterFactory;
import au.com.bgl.executer.ReportCommandExecuter;
import au.com.bgl.interf.Robot;

public class ReportCommandExecuterFacotyr implements ExecuterFactory,
		Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 6481856998652562691L;

	@Override
	public CommandExecuter buildExecuter(Command command, Robot robot) {
		return new ReportCommandExecuter(command);
	}

}
