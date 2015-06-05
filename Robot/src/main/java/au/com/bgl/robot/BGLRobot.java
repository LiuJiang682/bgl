package au.com.bgl.robot;

import java.io.Serializable;

import au.com.bgl.directions.Direction;
import au.com.bgl.interf.Robot;

/**
 * The BGL Robot implement class.
 * 
 * @author Jiang Liu
 *
 */
public class BGLRobot implements Robot, Serializable {

	/**
	 * Generated Serial Version UID. 
	 */
	private static final long serialVersionUID = -4548146814450674286L;

	private int x;
	private int y;
	private Direction facing;
	
	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public Direction getFacing() {
		return this.facing;
	}

	@Override
	public void setFacing(Direction facing) {
		this.facing = facing;
	}

}
