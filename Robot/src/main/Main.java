package main;

import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
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
		
		//Motor moottori = rM.moottori;
		//irs.start();
		int i = 1;
		while(!Button.ENTER.isDown()) {
			
			g.drawRegion(Images.getImage(i), 0, 0, SW, SH, GraphicsLCD.TRANS_NONE, SW/2, SH/2, GraphicsLCD.HCENTER | GraphicsLCD.VCENTER);
			g.refresh();
			/*if(cs.Stop == false) {
			moottori.drive(controls.getMotorSpeed());
			moottori.steer(controls.getSteeringAngle());
			}
			else {
				moottori.drive(0);
			}*/
			
			
			
			
		}
	
	
	}
}