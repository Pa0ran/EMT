package main;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.utility.Delay;

/**
 * @author	Sam Hemming, Niklas Malinen
 * @version	1.0
 * @since	7.5.2018
 */

public class ColorSensor extends Thread {
	
	private EV3ColorSensor colorSensor;
	public boolean Stop;
	private JaateloValinta icecreamMenu = new JaateloValinta();
	
	public ColorSensor(EV3ColorSensor colorSensor) {
		this.colorSensor = colorSensor;
	}
	/**
	 * Loops and gets colorSensors ColorID every 10ms
	 * Starts icecreamMenu.run() on blue
	 * Stops on red
	 * Runs on green
	 */
	@Override
	public void run() { //run when thread is started
		while (!Button.ENTER.isDown()) {
			switch(colorSensor.getColorID()) {
			case(Color.BLUE):
				//----------------------------------------------------------------------------
				Stop = true;
				//LCD.drawString("I'm seeing BLUE!!!", 0, 2); //for debug
				icecreamMenu.starttaa();
				Stop = false;
				//-----------------------------------------------------------------------------
				break;
			case(Color.GREEN):
				//continue();
				Stop = false;
				break;
			case(Color.RED):
				//Stop the the motors
				Stop = true;
				break;
			default:
				break;
			}
			Delay.msDelay(10);
		}
	}
}
