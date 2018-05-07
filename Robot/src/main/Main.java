package main;

import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RegulatedMotor;


/**
 * @author	Sam Hemming, Satu Lintala, Niklas Malinen, Esko Koskinen, Ilirjana Zymberi
 * @version	1.0
 * @since	7.5.2018
 */
public class Main {

	public static void main(String[] args) {

		JaateloValinta icecreamMenu = new JaateloValinta();
		GraphicsLCD gLCD = BrickFinder.getDefault().getGraphicsLCD();
		gLCD.setAutoRefresh(false);

		// motors
		RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
		RegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.B);
		RegulatedMotor motorC = new EV3MediumRegulatedMotor(MotorPort.C);

		Motor motor = new Motor(motorA, motorB, motorC);

		// music
		Music music = new Music();

		// routemanager
		RouteManager routeManager = new RouteManager(motor);

		// ir sensor
		EV3IRSensor infraredSensorEV3 = new EV3IRSensor(SensorPort.S1);
		IRSensor irSensor = new IRSensor(infraredSensorEV3);
		ControlSource controlSource = new ManualControl(irSensor, routeManager, music);

		// ColorSensor
		EV3ColorSensor colorSensorEV3 = new EV3ColorSensor(SensorPort.S2);
		ColorSensor colorSensor = new ColorSensor(colorSensorEV3);
		colorSensor.start();

		while (!Button.ENTER.isDown()) {
			if (colorSensor.Stop == false) {
				motor.drive(controlSource.getMotorSpeed());
				motor.steer(controlSource.getSteeringAngle());
			} else {
				motor.drive(0);
			}

		}

	}

}