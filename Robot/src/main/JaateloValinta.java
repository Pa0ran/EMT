package main;

import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.lcd.LCD;

/**
 * @author	Niklas Malinen, Esko Koskinen, Ilirjana Zymberi
 * @version	1.0
 * @since	7.5.2018
 */

public class JaateloValinta {
	double jaatelo1;
	double jaatelo2;
	double jaatelo3;
	double kassaSaldo;
	GraphicsLCD lcd;
	int i;
	//public JaateloValinta(double jaatelo1, double jaatelo2, double jaatelo3, double kassaSaldo) {
	public JaateloValinta() {
		this.jaatelo1 = 2.50;
		this.jaatelo2 = 3.25;
		this.jaatelo3 = 1.50;
		this.kassaSaldo = 10.50;
		this.i = 1;
		lcd = BrickFinder.getDefault().getGraphicsLCD();
		
	}
		
	public void starttaa() {
		while (!Button.ESCAPE.isDown()) {
			LCD.drawString("Hello", 0, 0);
			LCD.drawString("Mita saisi olla", 0, 1);
			
			while (!Button.ESCAPE.isDown()) {
				switch (this.i) {

				case 1:
					LCD.drawString("Jaatelo1: 2.50", 0, 2);
					lcd.drawImage(Images.getImage(Images.JAATELO_1), 64, 64, 0);
					if (Button.ENTER.isDown()) {
						kassaSaldo = kassaSaldo + jaatelo1;
                        i = 4;
					} else if (Button.DOWN.isDown()) {
						i++;
					}
					break;
				case 2:
					LCD.drawString("Jaatelo2: 3.25", 0, 2);
					lcd.drawImage(Images.getImage(Images.JAATELO_2), 64, 64, 0);
					if (Button.ENTER.isDown()) {
						kassaSaldo = kassaSaldo + jaatelo2;
                        i = 4;
					} else if (Button.DOWN.isDown()) {
						i++;
					} else if (Button.UP.isDown()) {
						i--;
					}

					break;
				case 3:
					LCD.drawString("Jaatelo3: 1.50", 0, 2);
					lcd.drawImage(Images.getImage(Images.JAATELO_3), 64, 64, 0);
					if (Button.ENTER.isDown()) {
						kassaSaldo = kassaSaldo + jaatelo3;
						i = 4;

					} else if (Button.DOWN.isDown()) {
						i = 1;
					} else if (Button.UP.isDown()) {
						i--;
					}
					

					break;
					
				default:

					LCD.drawString("Tulisiko viela muuta?", 0, 0);
					LCD.drawString("Jos tulee, niin paina Enteria", 0, 1);
					LCD.drawString("Jos ei, paina ESCAPE nappainta", 0, 2);
					
					if (Button.ESCAPE.isDown()) {
						break;
					}
                    break;
				}
			}
			break;
		}

	}
}
