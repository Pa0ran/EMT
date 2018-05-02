package main;

import lejos.hardware.Sound;

public class Music {
	public Music() {
	// TODO Auto-generated constructor stub
	}
	public void play() {
		Sound.playTone(aFrequency, aDuration, aVolume);
	}
}

