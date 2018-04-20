package main;

import lejos.hardware.lcd.LCD;

public class ManualControl implements ControlSource {

	int steeringAngle = 0;
	int direction = 0;
	IRSensor ir;
	public ManualControl(IRSensor ir) {
		this.ir = ir;
		ir.start();
	}
	@Override
	public int getSteeringAngle() {
		updateIR();
		int temp = steeringAngle;
		steeringAngle = 0;
		return temp;
	}

	@Override
	public int getMotorSpeed() {
		updateIR();
		// TODO Auto-generated method stub
		return direction*360;
	}
	
	public void updateIR() {
		int remoteNum = ir.getRemotecmd(3);
		LCD.drawString("Hello", 0, 0);
		LCD.drawInt(remoteNum,0,1);
		switch(remoteNum) {
		case 1: 
			direction = 1;
			break;
		case 2:
			direction = -1;
			break;
		case 3:
			steeringAngle = 30;
			break;
		case 4:
			steeringAngle = -30;
			break;
		case 9:
			direction = 0;
			break;
		}
	}

}
