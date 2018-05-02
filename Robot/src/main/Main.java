package main;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RegulatedMotor;

public class Main {
	
	static ControlSource controls;
	RouteManager rM;
	Motor moottori;
	
	public static void main(String[] args) {
		
		//ir sensor
		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S1);
		IRSensor irs = new IRSensor(irSensor);
		controls = new ManualControl(irs);
		
		//routemanager
		RouteManager rM = new RouteManager();
		
		//motors
		RegulatedMotor m1 = new EV3LargeRegulatedMotor(MotorPort.A);
		RegulatedMotor m2 = new EV3LargeRegulatedMotor(MotorPort.B);
		RegulatedMotor m3 = new EV3MediumRegulatedMotor(MotorPort.C);
		
		Motor moottori = new Motor(m1,m2,m3);
		
		//ColorSensor
		EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S2);
		ColorSensor cs = new ColorSensor(colorSensor, moottori);
		cs.start();
		
		//Motor moottori = rM.moottori;
		//irs.start();
		while(!Button.ENTER.isDown()) {
			moottori.drive(controls.getMotorSpeed());
			moottori.steer(controls.getSteeringAngle());
			}
			
			
			
		}
	
	
}