package main;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class IRSensor extends Thread {
	private EV3IRSensor infraredSensor;
		public IRSensor(EV3IRSensor sensor){
			this.infraredSensor = sensor;
		}
		// this is run when the thread is started
		
		public void run() {
			while (!Button.ENTER.isDown()) {
				int remoteCommand = infraredSensor.getRemoteCommand(3);
				if (remoteCommand != 0) {
					LCD.drawString("Painoit: " +
					remoteCommand, 0, 0);
					Delay.msDelay(50);
					
				}
								
			
			}
		}
		public int getRemotecmd(int channel) {
			
			return infraredSensor.getRemoteCommand(channel);
			}
}
		