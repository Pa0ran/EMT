package main;

import lejos.hardware.lcd.LCD;

public class ManualControl implements ControlSource {
	
	public boolean record =false;
	public int channel = 3;
	RouteManager route = new RouteManager();
	int steeringAngle = 0;
	int direction = 0;
	int what = 0;
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
		float timeNow = 0;
		float timeEnd;
		float timeTotal;
		int remoteNum = ir.getRemotecmd(channel);
		LCD.drawString("Hello", 0, 0);
		LCD.drawInt(remoteNum,0,1);
		if(channel == 3) {
			switch(remoteNum) {
			case 1: 
				direction = 1;
				if(record == true) {
					if(what != 1) {
						timeEnd = System.nanoTime();
						timeTotal = timeEnd-timeNow;
						route.Record(what,timeTotal);
					}
					timeNow = System.nanoTime();
					what = 1;
				}
				break;
			case 2:
				direction = -1;
				if(record == true) {
					if(what != 2) {
						timeEnd = System.nanoTime();
						timeTotal = timeEnd-timeNow;
						route.Record(what,timeTotal);
					}
					timeNow = System.nanoTime();
					what = 2;
				}
				break;
			case 3:
				steeringAngle = 30;
				if(record == true) {
					if(what != 3) {
						timeEnd = System.nanoTime();
						timeTotal = timeEnd-timeNow;
						route.Record(what,timeTotal);
					}
					timeNow = System.nanoTime();
					what = 3;
				}
				break;
			case 4:
				steeringAngle = -30;
				if(record == true) {
					if(what != 4) {
						timeEnd = System.nanoTime();
						timeTotal = timeEnd-timeNow;
						route.Record(what,timeTotal);
						
					}
					timeNow = System.nanoTime();
					what = 4;
				}
				break;
			case 9:
				direction = 0;
				if(record == true) {
					if(what != 9) {
						timeEnd = System.nanoTime();
						timeTotal = timeEnd-timeNow;
						route.Record(what,timeTotal);
					}
					timeNow = System.nanoTime();
					what = 9;
				}
				break;
			}
		}
	}

}
