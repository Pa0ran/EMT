package main;

import java.io.File;

import lejos.hardware.Sound;

public class Music {
	
	public void play() {
		File biisi= new File("JtelautoTunnari2.wav");
		Sound.playSample(biisi,100);
	}
}
