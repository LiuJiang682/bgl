package au.com.bgl.executer.factory;

import java.io.Serializable;

import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.command.interf.ExecuterFactory;
import au.com.bgl.executer.DoNothingExecuter;
import au.com.bgl.interf.Robot;

/**
 * The DoNothingExecuter factory class.
 * @author Jiang Liu
 *
 */
public class DoNothingExecutorFactory implements ExecuterFactory, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -9038719739747487275L;

	@Override
	public CommandExecuter buildExecuter(Command command, Robot robot) {
		return new DoNothingExecuter();
	}

}
