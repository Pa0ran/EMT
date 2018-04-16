package main;

import lejos.robotics.RegulatedMotor;

public class Motor {

	
	private RegulatedMotor mB;
	private RegulatedMotor mA;
	public Motor(RegulatedMotor mA, RegulatedMotor mB) {
		this.mA = mA;
		this.mB = mB;
		this.mA.setSpeed(900);
		this.mB.setSpeed(900);
		mA.synchronizeWith(new RegulatedMotor[] {mB});
	}
	
	public void Stop() {

		mA.rotate(0);
		mB.rotate(0);
		mA.stop();
		mB.stop();
	}
	public void DriveForward() {
		mA.startSynchronization();
		mA.rotate(360);
		mB.rotate(360);
		mA.endSynchronization();
	}
	public void DriveBackward() {
		mA.startSynchronization();
		mA.rotate(-360);
		mB.rotate(-360);
		mA.endSynchronization();
	}
	public void DriveLeft() {
		mB.setSpeed(450);
		mA.startSynchronization();
		mA.rotate(360);
		mB.rotate(360);
		mA.endSynchronization();
		
	}
	public void DriveRight() {
		mA.setSpeed(450);
		mA.startSynchronization();
		mA.rotate(360);
		mB.rotate(360);
		mA.endSynchronization();
		
	}
	

}
