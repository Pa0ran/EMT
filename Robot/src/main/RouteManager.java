package main;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class RouteManager {
	
	int[] whatDo;
	float[] time;
	public boolean Play = false;
	//Main head = new Main();
	public RouteManager() {
		
	}
	
	public void Record(int what,float howLong) {
		int count = 0;
		whatDo[count] = what;
		time[count] = howLong;
		count++;
	}
	/*public void Play() {
		Play = true;
		float timeStart = System.nanoTime();
		float timeStop;
		while(Play == true) {
			for(int i = 0;i<time.length;i++) {
				timeStart = System.nanoTime();
				timeStop = timeStart + time[i];
				if(whatDo[i] == 1) {
					while(time[i]< System.nanoTime()) {
						head.moottori.drive(900);
				
					}
				}
				else if (whatDo[i] == 2) {
					while(time[i]< System.nanoTime()) {
						head.moottori.drive(-900);
				
					}
				}
				else if (whatDo[i] == 3) {
					head.moottori.steer(30);
							}
				else if (whatDo[i] == 4) {
					head.moottori.steer(-30);
				}
				else if (whatDo[i] == 9) {
					head.moottori.Stop();
				}
			}
		}
	}*/
}
