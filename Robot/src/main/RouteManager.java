package main;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class RouteManager {
	
	private Motor moottori;
	public int[] whatDo = new int[50];
	public float[] time = new float[50];
	float[] route1Time = new float[5];
	public int[] route1what = new int[5];
	public boolean Play = false;
	public int length = 0;
	int count = 0;
	public RouteManager(Motor moottori) {
		
		this.moottori = moottori;
	}
	
	/**Store what to do and for how long in twin arrays.*/
	public void Record(int what,float howLong) {
		whatDo[count] = what;
		time[count] = howLong;
		count++;
		length++;
		
	}
	public void Route1() {
		float timeNow = System.nanoTime();
		float currentTime = System.nanoTime();
		for(int i = 0;i<route1what.length;i++) {
			 {

				if(route1what[i] == 1) {
					while(currentTime<=timeNow+ route1Time[i] ){
						moottori.drive(360);
						currentTime = System.nanoTime();
						
						
					}
					timeNow = System.nanoTime();
				}
				else if (route1what[i] == 2) {
					
					while(currentTime<=timeNow+ route1Time[i] ) {
						moottori.drive(-360);
						currentTime = System.nanoTime();
						
						
				
					}
					timeNow = System.nanoTime();
				}
				else if (route1what[i] == 3) {
					moottori.steer(30);
					timeNow = System.nanoTime();
							}
				else if (route1what[i] == 4) {
					moottori.steer(-30);
					timeNow = System.nanoTime();
				}
				else if (route1what[i] == 9) {
					while(currentTime<=timeNow+ route1Time[i] ) {
						moottori.drive(0);
						currentTime = System.nanoTime();
						
						
						
					}
					timeNow = System.nanoTime();
				}
			}
		}
	}
	// play the recorded route
	public void Play() {
		Play = true;
		float timeStart = System.nanoTime();
		float timeStop;
		float currentTime;
		while(Play == true) {
			for(int i = 0;i<length;i++) {
				timeStart = System.nanoTime();
				timeStop = System.nanoTime() + time[i];
				LCD.drawString(Float.toString(time[i]), 0, 5);
				LCD.drawString(Float.toString(timeStop), 0, 6);
				currentTime = System.nanoTime();
				if(whatDo[i] == 1) {
					while(timeStop >= currentTime) {
						moottori.drive(360);
						currentTime = System.nanoTime();
						LCD.drawString(Float.toString(currentTime), 0, 7);
						
					}
				}
				else if (whatDo[i] == 2) {
					
					while(timeStop >= currentTime) {
						moottori.drive(-360);
						currentTime = System.nanoTime();
						LCD.drawString(Float.toString(currentTime), 0, 7);
						
				
					}
				}
				else if (whatDo[i] == 3) {
					moottori.steer(30);
							}
				else if (whatDo[i] == 4) {
					moottori.steer(-30);
				}
				else if (whatDo[i] == 9) {
					while(timeStop >= currentTime) {
						moottori.drive(0);
						currentTime = System.nanoTime();
						LCD.drawString(Float.toString(currentTime), 0, 7);
						
						
					}
				}
			}
		}
	}
}
