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

	/** Stops the driving motors */
	public void Stop() {
		mA.rotate(0);
		mB.rotate(0);
		mA.stop();
		mB.stop();
	}

	/**
	 * Drives forwards by rotating motors by one turn in sync. Returns after
	 * rotation is complete
	 */
	public void DriveForward() {
		mA.startSynchronization();
		mA.rotate(-360);
		mB.rotate(-360);
		mA.endSynchronization();
	}

	/**
	 * Drives backwards by rotating motors by one turn i sync. Returns after
	 * rotation is complete
	 */
	public void DriveBackward() {
		mA.startSynchronization();
		mA.rotate(360);
		mB.rotate(360);
		mA.endSynchronization();
	}

	/** Sets steering wheels rotation to 30 degrees */
	public void DriveLeft() {
		mC.rotate(30);
	}

	/** Sets steering wheels rotation to -30 degrees */
	public void DriveRight() {
		mC.rotate(-30);
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

	/** Drive forwards(1) or backwards(2), based on the argument 1 or 2 */
	public void KeepDriving(int keep) {
		if (keep == 1) {
			DriveForward();
		} else if (keep == 2) {
			DriveBackward();
		}
	}

}
