package main;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class RouteManager {
	
	float b = 1000000000;
	private Motor moottori;
	public int[] whatDo = new int[50];
	public float[] time = new float[50];
	float[] route1Time = {3*b,3*b,2*b,1*b,3*b};
	public int[] route1what = {2,1,9,4,1};
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
	// play prerecorded route;
	public void Route1() {
		//starting time
		float timeNow = System.nanoTime();
		//current time
		float currentTime = System.nanoTime();
	
		//loop goes trough all pre-recorded commands
		for(int i = 0;i<route1Time.length;i++) {
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
		//starting time
		float timeNow = System.nanoTime();
		//current time
		float currentTime = System.nanoTime();
		while(Play == true) {
			for(int i = 0;i<=length;i++) {
				if(whatDo[i] == 1) {
					while(currentTime<=timeNow+ route1Time[i] && Play == true){
						moottori.drive(360);
						currentTime = System.nanoTime();
						LCD.drawString(Float.toString(currentTime), 0, 7);
						LCD.drawString(Float.toString(timeNow+route1Time[i]), 0, 6);
						LCD.drawInt(length,0,5);
						LCD.drawInt(i,0,4);
					}
					timeNow = System.nanoTime();
				}
				else if (whatDo[i] == 2) {
					
					while(currentTime<=timeNow+ route1Time[i] && Play == true) {
						moottori.drive(-360);
						currentTime = System.nanoTime();
						
				
					}
					//updates the starting time for the next move
					timeNow = System.nanoTime();
				}
				else if (whatDo[i] == 3) {
					moottori.steer(30);
					timeNow = System.nanoTime();
							}
				else if (whatDo[i] == 4) {
					moottori.steer(-30);
					timeNow = System.nanoTime();
				}
				else if (whatDo[i] == 9) {
					while(currentTime<=timeNow+ route1Time[i] && Play == true) {
						moottori.drive(0);
						currentTime = System.nanoTime();
						
					}
					timeNow = System.nanoTime();
				}
			}
			//set play to false to exit the loop after one completion
			Play = false;
		}
	}
}
