package au.com.bgl.executer.factory;

import java.io.Serializable;

import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.command.interf.ExecuterFactory;
import au.com.bgl.interf.Robot;

/**
 * The executor factory class.
 * 
 * @author Jiang Liu
 *
 */
public class ExecuterConstructFactory implements Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 7338274324833597485L;

	private ExecuterConstructFactory() {
		//prevent instantiation
	}

	public static CommandExecuter contructExecuter(Command command, Robot robot) {
		ExecuterFactory executerFactory = findExecuterFactory(command);
		return executerFactory.buildExecuter(command, robot);
	}

	public static ExecuterFactory findExecuterFactory(Command command) {
		ExecuterFactory factory = null;
		switch (command.getCommand()) {
			case PLACE:
				factory = new PlaceCommandExecuterFactory();
				break;
				
			case MOVE:
				factory = new MoveCommonExecuterFactory();
				break;
			
			case LEFT:
			    factory = new LeftCommandExecuterFactory();
			    break;
			    
			case RIGHT:
				factory = new RightCommandExecuterFactory();
				break;
				
			case REPORT:
				factory = new ReportCommandExecuterFacotyr();
				break;
				
			case DONOTHING:
			default:
				factory = new DoNothingExecutorFactory();
		}
		return factory;
	}
}
