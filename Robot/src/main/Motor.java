package main;

import lejos.robotics.RegulatedMotor;

/**
 * @author	Niklas Malinen, Esko Koskinen
 * @version	1.0
 * @since	7.5.2018
 */

public class Motor {

	/** LeftMotor */
	private RegulatedMotor mB;
	/** RightMotor */
	private RegulatedMotor mA;
	/** SteeringMotor */
	private RegulatedMotor mC;

	public Motor(RegulatedMotor mA, RegulatedMotor mB, RegulatedMotor mC) {
		this.mA = mA;
		this.mB = mB;
		this.mC = mC;
		this.mA.setSpeed(900);
		this.mB.setSpeed(900);
		mA.synchronizeWith(new RegulatedMotor[] { mB }); // Synchronize rightmotor with left
	}

	/**
	 * Drive given amount of degrees. Synchronous. Positive is backward and negative
	 * is forward
	 */
	public void drive(int rotation) {
		mA.startSynchronization();
		mA.rotate(rotation);
		mB.rotate(rotation);
		mA.endSynchronization();
	}

	/**
	 * Steers wheels by given amount(Degrees) Left is positive and Right is negative
	 */
	public void steer(int angle) {
		mC.rotate(angle);
	}

	
	

}
