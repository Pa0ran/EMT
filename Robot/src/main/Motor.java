package main;

import lejos.robotics.RegulatedMotor;

public class Motor {

	
	private RegulatedMotor mB;
	private RegulatedMotor mA;
	private RegulatedMotor mC;
	public Motor(RegulatedMotor mA, RegulatedMotor mB,RegulatedMotor mC) {
		this.mA = mA;
		this.mB = mB;
		this.mC = mC;
		this.mA.setSpeed(300);
		this.mB.setSpeed(300);
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
		mA.rotate(-360);
		mB.rotate(-360);
		mA.endSynchronization();
	}
	public void DriveBackward() {
		mA.startSynchronization();
		mA.rotate(360);
		mB.rotate(360);
		mA.endSynchronization();
	}
	public void DriveLeft() {
		mC.rotate(30);
		
		
	}
	public void DriveRight() {
		mC.rotate(-30);
	
		
	}
	
	public void drive(int rotation) {
		mA.startSynchronization();
		mA.rotate(rotation);
		mB.rotate(rotation);
		mA.endSynchronization();
	}
	
	public void steer(int angle) {
		mC.rotate(angle);
	}
	
	public void KeepDriving(int keep) {
		if (keep == 1) {
			DriveForward();
		}
		else if (keep == 2) {
			DriveBackward();
		}
	}
	

}
