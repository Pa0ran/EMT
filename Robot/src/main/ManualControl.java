package main;

import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

/**
 * @author	Niklas Malinen, Esko Koskinen
 * @version	1.0
 * @since	7.5.2018
 */

public class ManualControl implements ControlSource {
	
	public boolean Record = false;
	public int Channel = 3;
	int steeringAngle = 0;
	int direction = 0;
	int what = 1;
	private RouteManager routeManager;
	private Music music;
	public boolean Playmusic;
	IRSensor infraredSensor;
	
	/**
	 * get irsensor and start its thread
	 * @param	IRSensor ir, RouteManager rM, Music music
	 * 
	 */
	public ManualControl(IRSensor ir,RouteManager rM,Music music) {	
		this.infraredSensor = ir;
		this.routeManager = rM;
		this.music = music;
		ir.start();
	}
	
	/**
	 * gets stearingAngle, returns it and then sets it to 0
	 * @return	int steeringAngle = -30 or 30
	 */
	@Override
	public int getSteeringAngle() {
		updateIR();
		int temp = steeringAngle;
		steeringAngle = 0;
		return temp;
	}

	/**
	 * returns motors direction*360 and calls 'updateIR()'
	 * @return	int direction*360 = -360, 0 or 360
	 */
	@Override
	public int getMotorSpeed() {
		updateIR();
		return direction*360;
	}
	
	/**
	 * Updates IR connection, by getting commands from channel 3 and 2
	 * 
	 * 
	 */
	public void updateIR() {
		float timeStart = System.nanoTime();
		float timeEnd;
		float timeElapsed;
		int remoteChan3 = infraredSensor.getRemotecmd(3);
		int remoteChan2 = infraredSensor.getRemotecmd(2);
		int remoteChan1 = infraredSensor.getRemotecmd(1);
		int remoteChan0 = infraredSensor.getRemotecmd(0);
		LCD.drawString("Hello", 0, 0);
		LCD.drawInt(Channel, 0, 4);

		switch (remoteChan3) {
		// Drive backward
		case 1:
			direction = 1;
			if (Record == true) {
				if (what != 1) {
					timeEnd = System.nanoTime();
					timeElapsed = timeEnd - timeStart;
					routeManager.Record(what, timeElapsed);
				}
				timeStart = System.nanoTime();
				what = 1;
			}
			break;
		// Drive forward
		case 2:
			direction = -1;
			if (Record == true) {
				if (what != 2) {
					timeEnd = System.nanoTime();
					timeElapsed = timeEnd - timeStart;
					routeManager.Record(what, timeElapsed);
				}
				timeStart = System.nanoTime();
				what = 2;
			}
			break;
		// Steer right
		case 3:
			steeringAngle = 30;
			if (Record == true) {
				if (what != 3) {
					timeEnd = System.nanoTime();
					timeElapsed = timeEnd - timeStart;
					routeManager.Record(what, timeElapsed);
				}
				timeStart = System.nanoTime();
				what = 3;
			}
			break;
		// Steer left
		case 4:
			steeringAngle = -30;
			if (Record == true) {
				if (what != 4) {
					timeEnd = System.nanoTime();
					timeElapsed = timeEnd - timeStart;
					routeManager.Record(what, timeElapsed);

				}
				timeStart = System.nanoTime();
				what = 4;
			}
			break;
		// Stop
		case 9:
			direction = 0;
			if (Record == true) {
				if (what != 9) {
					timeEnd = System.nanoTime();
					timeElapsed = timeEnd - timeStart;
					routeManager.Record(what, timeElapsed);
				}
				timeStart = System.nanoTime();
				what = 9;
			}
			break;
		}

		switch (remoteChan2) {
		// start recording
		case 1:
			Record = true;
			Sound.beep();
			break;
		// stop recording
		case 2:
			Record = false;
			break;
		// drive recorded route
		case 3:
			Record = false;
			Sound.beep();
			Sound.beep();
			routeManager.Play();
			routeManager.Play = true;
			break;
		// cancel current route
		case 4:
			routeManager.Play = false;
			break;
		}
		// play prerecorded route
		switch (remoteChan1) {
		case 1:
			routeManager.Route1();
			break;
		}
		// play music
		switch (remoteChan0) {
		case 1:
			if (this.music.getState() == Thread.State.TERMINATED) {
				this.music = new Music();
			} else if (!this.music.isAlive()) {
				this.music.start();
			} else {
				Delay.msDelay(10);
			}
			break;
		}

	}

	@Override
	public String getName() {
		return "Manual Control";
	}

}
