package main;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;

public class ColorSensor extends Thread {
	private EV3ColorSensor cs;
	private Motor motor;
	public boolean Stop;
//	public boolean shopOpen = false;
	private JaateloValinta jaatelo = new JaateloValinta();
	
	public ColorSensor(EV3ColorSensor colorSensor, Motor motor) {
		this.cs = colorSensor;
		this.motor = motor;
		
	}
	
	@Override
	public void run() { //run when thread is started
		while (!Button.ENTER.isDown()) {
			switch(cs.getColorID()) {
			case(Color.BLACK):
				break;
			case(Color.BLUE):
				//----------------------------------------------------------------------------
//				if (!shopOpen) {
					LCD.drawString("I'm seeing BLUE!!!", 0, 2); //for debug
//					shopOpen = true; //prevents shop from opening twice
					jaatelo.starttaa(); //for reference
//					shopOpen = false; //assuming that the code is stuck in the "jaatelo" for its execution time
					//change shopOpen to false before closing the shop so that it can't open twice
//				}
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
