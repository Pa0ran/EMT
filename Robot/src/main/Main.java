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
	
	static ControlSource controls;
	
	public static void main(String[] args) {
		boolean record =false;
		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S1);
		IRSensor irs = new IRSensor(irSensor);;
		RegulatedMotor m1 = new EV3LargeRegulatedMotor(MotorPort.A);
		RegulatedMotor m2 = new EV3LargeRegulatedMotor(MotorPort.B);
		RegulatedMotor m3 = new EV3MediumRegulatedMotor(MotorPort.C);
		Motor moottori = new Motor(m1,m2,m3);
		RouteManager route = new RouteManager();
		controls = new ManualControl(irs);
		//irs.start();
		while(!Button.ENTER.isDown()) {
			moottori.drive(controls.getMotorSpeed());
			moottori.steer(controls.getSteeringAngle());
		}
	}
}
