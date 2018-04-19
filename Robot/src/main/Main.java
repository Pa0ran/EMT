package main;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RegulatedMotor;

public class Main {
	
	public static void main(String[] args) {
		int remoteNum;
		int keep = 0;
		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S1);
		IRSensor irs = new IRSensor(irSensor);;
		RegulatedMotor m1 = new EV3LargeRegulatedMotor(MotorPort.A);
		RegulatedMotor m2 = new EV3LargeRegulatedMotor(MotorPort.B);
		RegulatedMotor m3 = new EV3MediumRegulatedMotor(MotorPort.C);
		Motor moottori = new Motor(m1,m2,m3); 
		irs.start();
		while(!Button.ENTER.isDown()) {
			remoteNum = irs.getRemotecmd(3);
			LCD.drawString("Hello", 0, 0);
			LCD.drawInt(remoteNum,0,1);
			switch(remoteNum) {
			case 1 : 
				moottori.DriveForward();
				keep = 1;
				break;
			case 2:
				moottori.DriveBackward();
				keep = 2;
				break;
			case 3:
				moottori.DriveRight();
				break;
			case 4:
				moottori.DriveLeft();
				break;
			case 9:
				moottori.Stop();
				keep = 0;
				break;
			default:
				moottori.KeepDriving(keep);
				break;
			}
			
			
			
		}
	}

}
