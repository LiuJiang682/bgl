package au.com.bgl.command.factory;

import java.io.Serializable;

import au.com.bgl.command.LeftCommand;
import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandFactory;

/**
 * The left command factory class.
 * @author Jiang Liu
 *
 */
public class LeftCommandFactory implements CommandFactory, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = 8453453567494682889L;

	@Override
	public Command buildCommand(String commandString) {
		return new LeftCommand();
	}

}
