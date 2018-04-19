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
		mB.setSpeed(900);
		mA.setSpeed(900);
		mA.startSynchronization();
		mA.rotate(-360);
		mB.rotate(-360);
		mA.endSynchronization();
	}
	public void DriveBackward() {
		mB.setSpeed(900);
		mA.setSpeed(900);
		mA.startSynchronization();
		mA.rotate(360);
		mB.rotate(360);
		mA.endSynchronization();
	}
	public void DriveLeft() {
		mB.setSpeed(300);
		mA.startSynchronization();
		mA.rotate(-360);
		mB.rotate(-360);
		mA.endSynchronization();
		
		
	}
	public void DriveRight() {
		mA.setSpeed(300);
		mA.startSynchronization();
		mA.rotate(-360);
		mB.rotate(-360);
		mA.endSynchronization();
		mA.setSpeed(900);
		
	}
	public void KeepDriving(int keep) {
		if (keep == 1) {
			DriveForward();
		}
		else if (keep == 2) {
			DriveBackward();
		}
		else if (keep == 3) {
			DriveLeft();
		}
		else if (keep == 4) {
			DriveRight();
		}
	}
	

}
