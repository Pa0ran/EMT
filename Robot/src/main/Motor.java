package main;

import lejos.robotics.RegulatedMotor;

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
		this.mA.setSpeed(300);
		this.mB.setSpeed(300);
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
