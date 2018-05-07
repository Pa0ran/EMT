package main;

import java.io.File;
import lejos.hardware.Sound;

/**
 * @author	Satu Lintala, Niklas Malinen, Sam Hemming
 * @version	1.0
 * @since	7.5.2018
 */

public class Music extends Thread{
	
	public Music() {
		
	}
	
	@Override
	public void run() {
		File biisi= new File("JtelautoTunnari2.wav");
		Sound.playSample(biisi,100);
	}
}
