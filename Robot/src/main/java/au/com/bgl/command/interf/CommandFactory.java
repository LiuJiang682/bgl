package au.com.bgl.command.interf;

/**
 * The command factory interface.
 * 
 * @author Jiang Liu
 *
 */
public interface CommandFactory {

	Command buildCommand(final String commandString);
}
