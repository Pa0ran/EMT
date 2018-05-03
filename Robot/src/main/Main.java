package main;

import java.io.File;

import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Main {
	
	static ControlSource controls;
	RouteManager rM;
	Motor moottori;
	
	
	
	public static void main(String[] args) {
		
		
		
		GraphicsLCD  g = BrickFinder.getDefault().getGraphicsLCD();
		g.setAutoRefresh(false);
		final int SW = g.getWidth();
		final int SH = g.getHeight();
		//motors
		RegulatedMotor m1 = new EV3LargeRegulatedMotor(MotorPort.A);
		RegulatedMotor m2 = new EV3LargeRegulatedMotor(MotorPort.B);
		RegulatedMotor m3 = new EV3MediumRegulatedMotor(MotorPort.C);
		
		Motor moottori = new Motor(m1,m2,m3);
		
		Music music = new Music();
		//routemanager
		RouteManager rM = new RouteManager(moottori);
		//ir sensor
		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S1);
		IRSensor irs = new IRSensor(irSensor);
		controls = new ManualControl(irs,rM);
				
		//ColorSensor
		EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S2);
		ColorSensor cs = new ColorSensor(colorSensor, moottori);
		cs.start();
		music.play();	
		while(!Button.ENTER.isDown()) {
			//draw pictures of ice cream example
			//g.drawImage(Images.getImage(1), 0, 0,0);
			//g.refresh();
			if(cs.Stop == false) {
			moottori.drive(controls.getMotorSpeed());
			moottori.steer(controls.getSteeringAngle());
			}
			else {
				moottori.drive(0);
			}
			
			
			
			
			
			
		}
	
	
	}
	
}