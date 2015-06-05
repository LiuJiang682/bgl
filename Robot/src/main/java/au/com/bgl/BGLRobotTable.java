package au.com.bgl;

import java.io.Serializable;
import java.util.Scanner;

import au.com.bgl.command.factory.CommandConstructFactory;
import au.com.bgl.command.interf.Command;
import au.com.bgl.command.interf.CommandExecuter;
import au.com.bgl.executer.factory.ExecuterConstructFactory;
import au.com.bgl.interf.Robot;
import au.com.bgl.interf.RobotTable;

public class BGLRobotTable implements RobotTable, Serializable {

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -7453796625968290202L;

	private static final int MAX_X = 5;
	private static final int MAX_Y = 5;

	private Robot robot;

	// default constructor
	public BGLRobotTable() {

	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	@Override
	public int getMaxX() {
		return MAX_X;
	}

	@Override
	public int getMaxY() {
		return MAX_Y;
	}

	/**
	 * This method returns a command object. It use abstract factory pattern to
	 * create factory object and than the factory object creates command object.
	 * 
	 * @return command object.
	 */
	public Command getNextCommand(final Scanner scanner) {
		Command command = null;

		// User interactive mode
		System.out.println("Please enter your command: ");
		String userEntered = scanner.nextLine();
		command = CommandConstructFactory.constructCommand(userEntered);

		return command;
	}

	/**
	 * This method returns a command executer object which will execute the
	 * command.
	 * 
	 * @param command
	 *            the command.
	 * @param robot
	 *            the robot.
	 * @return the executer.
	 */
	public CommandExecuter getExecuter(Command command, Robot robot) {

		return ExecuterConstructFactory.contructExecuter(command, robot);
	}
	
	public Scanner getScanner() {
		Scanner scanner = new Scanner(System.in);
		return scanner;
	}

	public void run() {
		Command command = null;

		Scanner scanner = getScanner();
		try {
			/**
			 * May consider use queue here for large work load.
			 */
			while ((command = getNextCommand(scanner)) != null) {
				if (command.isValidCommand()) {
					CommandExecuter executer = getExecuter(command, getRobot());
					executer.execute(this);
				}
			}
		} finally {
			scanner.close();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BGLRobotTable table = new BGLRobotTable();
		table.run();
	}

}
