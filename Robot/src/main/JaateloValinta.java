package main;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

public class JaateloValinta {
	double jaatelo1;
	double jaatelo2;
	double jaatelo3;
	double kassaSaldo;

	public JaateloValinta(double jaatelo1, double jaatelo2, double jaatelo3, double kassaSaldo) {
		this.jaatelo1 = 2.50;
		this.jaatelo2 = 3.25;
		this.jaatelo3 = 1.50;
		this.kassaSaldo = 10.50;

		String jaatelot[] = { "Mansikkajäätelo", "Suklaajäätelö", "Lakritsijäätelö" };

		for (int i = 0; i < jaatelot.length; i++) {

			LCD.drawString("Päivää", 0, 0);
			LCD.drawString("Mitä saisi olla?", 0, 0);
			LCD.drawString("Tarjolla olisi mansikkajäätelöä, suklaajäätelöa ja lakritsijäätelöä.", 0, 0);
			LCD.drawString("Jos haluat ostaa jäätelöä paina Enter näppäintä", 0, 0);
			LCD.clear();

			while (!Button.ESCAPE.isDown()) {
				if (Button.DOWN.isDown()) {
					i++;
					LCD.drawString("Mansikkajäätelö", 0, 0);
					if (Button.ENTER.isDown()) {
						kassaSaldo = kassaSaldo + jaatelo1;

					}
					if (Button.DOWN.isDown()) {
						i++;
						LCD.drawString("Suklaajäätelö", 0, 0);
						if (Button.ENTER.isDown()) {
							kassaSaldo = kassaSaldo + jaatelo2;
						}
						if (Button.DOWN.isDown()) {
							i++;
							LCD.drawString("Lakritsijäätelö", 0, 0);
							if (Button.ENTER.isDown()) {
								kassaSaldo = kassaSaldo + jaatelo3;
							}
							if (Button.DOWN.isDown()) {
								i++;
								LCD.drawString("Tulisiko vielä muuta?", 0, 0);
								LCD.drawString("Jos tulee, niin paina Enteriä", 0, 0);
								LCD.drawString("Jos ei, paina ESCAPE näppäintä", 0, 0);
								if (Button.ENTER.isDown()) {
									continue;
								}
								
							}
							break;
						}

					}
					/*
					 * if (Button.UP.isDown() || i > 1) { i--; }
					 */

					/*
					 * while (!Button.ESCAPE.isDown()) {
					 * 
					 * if (Button.LEFT.isDown()) { 
					 * // LCD.drawString("Mansikkajäätelö", 0, 0);
					 * kassaSaldo = kassaSaldo + jaatelo1; 
					 * LCD.clear(); }else if (Button.RIGHT.isDown()) { // LCD.drawString("Suklaajäätelö", 0, 0);
					 * kassaSaldo = kassaSaldo + jaatelo2; LCD.clear(); } else if
					 * (Button.DOWN.isDown()) { // LCD.drawString("Lakritsijäätelö", 0, 0);
					 * kassaSaldo = kassaSaldo + jaatelo3; LCD.clear(); } else if
					 * (Button.UP.isDown()) { LCD.drawString("Do you want to buy more ice cream?",
					 * 0, 0); LCD.drawString("If you do, press button ENTER", 0, 0);
					 * LCD.drawString("If you want to quit, press ESCAPE button", 0, 0); if
					 * (Button.ENTER.isDown()) { continue; } if (Button.ESCAPE.isDown()) { break; }
					 * 
					 * }
					 * 
					 * LCD.drawString("Kassan saldo:" + kassaSaldo, 0, 0);
					 * 
					 * }
					 */
				}

				// for (String menu : jaatelot) {

				// }

			}
		}
	}
}
