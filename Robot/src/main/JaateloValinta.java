package main;

import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.lcd.LCD;

/**
 * @author Niklas Malinen, Esko Koskinen, Ilirjana Zymberi, Sam Hemming
 * @version 1.0
 * @since 7.5.2018
 */

public class JaateloValinta {
	double jaatelo1;
	double jaatelo2;
	double jaatelo3;
	double jaatelo4;
	double kassaSaldo;
	GraphicsLCD gLCD;
	int i, button;

	// public JaateloValinta(double jaatelo1, double jaatelo2, double jaatelo3,
	// double kassaSaldo) {
	public JaateloValinta() {
		this.jaatelo1 = 2.50;
		this.jaatelo2 = 3.25;
		this.jaatelo3 = 1.50;
		this.jaatelo4 = 0.50;
		this.kassaSaldo = 10.50;
		this.i = 1;
		gLCD = BrickFinder.getDefault().getGraphicsLCD();

	}

	public void starttaa() {


			while (!Button.ESCAPE.isDown()) {
				LCD.clear();
				gLCD.clear();
				LCD.drawString("Hello", 0, 0);
				LCD.drawString("Mita saisi olla", 0, 1);
				
				switch (this.i) {
				case 1:
					LCD.drawString("Jaatelo1: 2.50", 0, 2);
					gLCD.drawImage(Images.getImage(Images.JAATELO_1), 64, 64, 0);
					
					button = Button.waitForAnyPress();
					
					if (button == Button.ID_ENTER) {
						kassaSaldo = kassaSaldo + jaatelo1;
						i = -1;
					} else if (button == Button.ID_DOWN) {
						i++;
					} else if (button == Button.ID_UP) {
						i = 4;
					}
					break;
				case 2:
					LCD.drawString("Jaatelo2: 3.25", 0, 2);
					gLCD.drawImage(Images.getImage(Images.JAATELO_2), 64, 64, 0);
					
					button = Button.waitForAnyPress();
					
					if (button == Button.ID_ENTER) {
						kassaSaldo = kassaSaldo + jaatelo2;
						i = -1;
					} else if (button == Button.ID_DOWN) {
						i++;
					} else if (button == Button.ID_UP) {
						i--;
					}

					break;
				case 3:
					LCD.drawString("Jaatelo3: 1.50", 0, 2);
					gLCD.drawImage(Images.getImage(Images.JAATELO_3), 64, 64, 0);
					
					button = Button.waitForAnyPress();
					
					if (button == Button.ID_ENTER) {
						kassaSaldo = kassaSaldo + jaatelo3;
						i = -1;

					} else if (button == Button.ID_DOWN) {
						i++;
					} else if (button == Button.ID_UP) {
						i--;
					}

					break;
				case 4:
					LCD.drawString("Jaatelo4: 0.50", 0, 2);
					gLCD.drawImage(Images.getImage(Images.JAATELO_4), 64, 64, 0);

					button = Button.waitForAnyPress();

					if (button == Button.ID_ENTER) {
						kassaSaldo = kassaSaldo + jaatelo3;
						i = -1;

					} else if (button == Button.ID_DOWN) {
						i = 1;
					} else if (button == Button.ID_UP) {
						i--;
					}

					break;

				default:
					LCD.clear();
					gLCD.clear();
					LCD.drawString("Tulisiko viela muuta?", 0, 0);
					LCD.drawString("Jos tulee, niin paina Enteria", 0, 1);
					LCD.drawString("Jos ei, paina ESCAPE nappainta", 0, 2);
					
					button = Button.waitForAnyPress();
					if (button == Button.ID_ENTER) {
						i = 1;
					}
					break;
				}
			}
		

	}
}
