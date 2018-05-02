package main;

import lejos.hardware.Button;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;

public class ColorSensor extends Thread {
	private EV3ColorSensor cs;
	private Motor motor;
	
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
				motor.Stop();
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
