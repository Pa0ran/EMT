package main;

/**
 * @author	Esko Koskinen
 * @version	1.0
 * @since	7.5.2018
 */

public interface ControlSource {
	public int getSteeringAngle();
	public int getMotorSpeed();
	public String getName();
}
