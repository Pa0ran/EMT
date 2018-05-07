package main;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

/**
 * Handles the IRSensors connection getting
 * and provides the getRemotecmd()
 * @author	Niklas Malinen
 * @version	1.0
 * @since	7.5.2018
 */

public class IRSensor extends Thread {
	private EV3IRSensor infraredSensor;

	public IRSensor(EV3IRSensor sensor) {
		this.infraredSensor = sensor;
	}

	// this is run when the thread is started
	@Override
	public void run() {
		while (!Button.ENTER.isDown()) {	//till enter is pressed, listen ir channel 3, and print it on lcd if not 0.
			int remoteCommand = infraredSensor.getRemoteCommand(3);
			if (remoteCommand != 0) {
				LCD.drawString("Painoit: " + remoteCommand, 0, 0);
				Delay.msDelay(50);

			}

		}
	}

	/**irsensor command getter for other classes*/
	public int getRemotecmd(int channel) {
		return infraredSensor.getRemoteCommand(channel);
	}
}
	