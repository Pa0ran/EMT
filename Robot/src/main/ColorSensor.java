package main;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;

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
	
	@Override
	public void run() { //run when thread is started
		while (!Button.ENTER.isDown()) {
			switch(colorSensor.getColorID()) {
			case(Color.BLACK):
				break;
			case(Color.BLUE):
				//----------------------------------------------------------------------------
				Stop = true;
				LCD.drawString("I'm seeing BLUE!!!", 0, 2); //for debug
				icecreamMenu.starttaa();
				Stop = false;
				//-----------------------------------------------------------------------------
				break;
			case(Color.BROWN):
				break;
			case(Color.CYAN):
				break;
			case(Color.DARK_GRAY):
				break;
			case(Color.GRAY):
				break;
			case(Color.GREEN):
				//continue();
				Stop = false;
				break;
			case(Color.LIGHT_GRAY):
				break;
			case(Color.MAGENTA):
				break;
			case(Color.NONE):
				break;
			case(Color.ORANGE):
				break;
			case(Color.PINK):
				break;
			case(Color.RED):
				//Stop the the motors
				Stop = true;
				break;
			case(Color.WHITE):
				break;
			case(Color.YELLOW):
				break;
			default:
				break;
			}
		}
	}
}
