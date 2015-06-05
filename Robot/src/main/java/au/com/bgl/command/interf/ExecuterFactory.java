package au.com.bgl.command.interf;

import au.com.bgl.interf.Robot;


/**
 * The executor factory interface.
 * @author Jiang Liu
 *
 */
public interface ExecuterFactory {
	CommandExecuter buildExecuter(Command command, Robot robot);
}
