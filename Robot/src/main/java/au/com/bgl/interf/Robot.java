package au.com.bgl.interf;

import au.com.bgl.directions.Direction;

/**
 * The robot interface. 
 * 
 * @author Jiang Liu
 *
 */
public interface Robot {

	// X axis methods
	public int getX();
	public void setX(int x);
	
	// Y axis methods
	public int getY();
	public void setY(int y);
	
	// Facing methods
	public Direction getFacing();
	public void setFacing(Direction facing);
}
