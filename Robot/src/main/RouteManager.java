package main;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class RouteManager {
	
	private int[] whatDo;
	private float[] time;
	public boolean Play = false;
	RegulatedMotor m1 = new EV3LargeRegulatedMotor(MotorPort.A);
	RegulatedMotor m2 = new EV3LargeRegulatedMotor(MotorPort.B);
	RegulatedMotor m3 = new EV3MediumRegulatedMotor(MotorPort.C);
	Motor moottori = new Motor(m1,m2,m3);
	public RouteManager() {
		
	}
	
	public void Record(int what,float howLong) {
		int count = 0;
		whatDo[count] = what;
		time[count] = howLong;
		count++;
	}
	public void Play() {
		Play = true;
		float timeStart = System.nanoTime();
		float timeStop;
		while(Play == true) {
			for(int i = 0;i<time.length;i++) {
				if(whatDo[i] == 1) {
					
				}
				else if (whatDo[i] == 2) {
					moottori.DriveBackward();
				}
				else if (whatDo[i] == 3) {
					moottori.DriveLeft();
							}
				else if (whatDo[i] == 4) {
					moottori.DriveRight();
				}
				else if (whatDo[i] == 9) {
					moottori.Stop();
				}
			}
		}
	}
}
