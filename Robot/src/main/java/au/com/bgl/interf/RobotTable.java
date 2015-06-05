package au.com.bgl.interf;

/**
 * The interface for robot table.
 * 
 * @author Jiang Liu
 *
 */
public interface RobotTable {

	Robot getRobot();
	void setRobot(Robot robot);
	
	int getMaxX();
	int getMaxY();
}
