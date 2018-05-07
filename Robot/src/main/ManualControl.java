package main;

import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;

/**
 * @author	Niklas Malinen, Esko Koskinen
 * @version	1.0
 * @since	7.5.2018
 */

public class ManualControl implements ControlSource {
	
	public boolean record = false;
	public int channel = 3;
	int steeringAngle = 0;
	int direction = 0;
	int what = 1;
	private RouteManager route;
	private Music music;
	public boolean playmusic;
	IRSensor ir;
	
	/**get irsensor and start its thread*/
	public ManualControl(IRSensor ir,RouteManager rM,Music music) {	
		this.ir = ir;
		this.route = rM;
		this.music = music;
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
	
	/**Updates IR connection, by getting commands from channel 3 and 2*/
	public void updateIR() {
		float timeNow = System.nanoTime();
		float timeEnd;
		float timeTotal;
		int remoteChan3 = ir.getRemotecmd(3);
		int remoteChan2 = ir.getRemotecmd(2);
		int remoteChan1 = ir.getRemotecmd(1);
		int remoteChan0 = ir.getRemotecmd(0);
		LCD.drawString("Hello", 0, 0);
		LCD.drawInt(channel,0,4);
		
		
		switch(remoteChan3) {
		//Drive backward
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
		//Drive forward
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
		//Steer right
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
		//Steer left
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
		//Stop
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
	

		switch(remoteChan2) {
		//start recording
		case 1:
			record = true;
			Sound.beep();
			break;
		
		//stop recording
		case 2:
			record = false;
			break;
		//drive recorded route
		case 3:
			record = false;
			Sound.beep();
			Sound.beep();
			route.Play();
			route.Play = true;
			break;
		// cancel current route
		case 4:
			route.Play = false;
			break;
			
			
		}
		//play prerecorded route
		switch(remoteChan1) {
		case 1:
			route.Route1();
			break;
		case 2:
		
			
			
		}
		//play music
		switch(remoteChan0) {
		case 1:
			music.start();
			break;
		}
		
	}

	@Override
	public String getName() {
		return "Manual Control";
	}

}
