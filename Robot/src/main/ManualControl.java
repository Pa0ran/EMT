package main;

import lejos.hardware.lcd.LCD;

public class ManualControl implements ControlSource {
	
	public boolean record = false;
	public int channel = 3;
	int steeringAngle = 0;
	int direction = 0;
	int what = 0;
	
	RouteManager route = new RouteManager();
	IRSensor ir;
	
	/**get irsensor and start its thread*/
	public ManualControl(IRSensor ir) {	
		this.ir = ir;
		ir.start();
	}
	
	/**gets stearingAngle, returns it and then sets it to 0*/
	@Override
	public int getSteeringAngle() {
		updateIR();
		int temp = steeringAngle;
		steeringAngle = 0;
		return temp;
	}

	/**returns motors direction*360 and calls 'updateIR()'*/
	@Override
	public int getMotorSpeed() {
		updateIR();
		return direction*360;
	}
	
	/**En lähteny koskee, koska hiton sotku*/
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
		else if(channel == 2) {
			switch(remoteNum) {
			case 1:
				record = true;
			case 2:
				record = false;
			case 3:
				route.Play();
				route.Play = true;
	
				
				
			}
		}
	}

}
