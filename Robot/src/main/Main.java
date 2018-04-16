package main;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RegulatedMotor;

public class Main {
	
	public static void main(String[] args) {
		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S4);
		IRSensor irs = new IRSensor(irSensor);;
		RegulatedMotor m1 = new EV3LargeRegulatedMotor(MotorPort.A);
		RegulatedMotor m2 = new EV3LargeRegulatedMotor(MotorPort.B);
		Motor moottori = new Motor(m1,m2); 
	}

}
