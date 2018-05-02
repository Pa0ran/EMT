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

		int i = 0;

		while (!Button.ESCAPE.isDown()) {
			LCD.drawString("Päivää", 0, 0);
			LCD.drawString("Mitä saisi olla?", 0, 0);
			LCD.drawString("Tarjolla olisi mansikkajäätelöä, suklaajäätelöa ja lakritsijäätelöä.", 0, 0);
			LCD.drawString("Jos haluat ostaa jäätelöä paina Enter näppäintä", 0, 0);
			LCD.clear();

			switch (i) {

			case 1:
				if (Button.ENTER.isDown()) {
					LCD.drawString("Jaatelo1", 0, 0);
					kassaSaldo = kassaSaldo + jaatelo1;

				} else {
					i++;
				}
				break;
			case 2:
				if (Button.ENTER.isDown()) {
					LCD.drawString("Jaatelo2", 0, 0);
					kassaSaldo = kassaSaldo + jaatelo2;

				} else {
					i++;
				}

				break;
			case 3:
				if (Button.ENTER.isDown()) {
					LCD.drawString("Jaatelo3", 0, 0);
					kassaSaldo = kassaSaldo + jaatelo3;

				} else {
					i++;
				}
				break;
			default:

				if (Button.DOWN.isDown()) {
					i++;
					LCD.drawString("Tulisiko vielä muuta?", 0, 0);
					LCD.drawString("Jos tulee, niin paina Enteriä", 0, 0);
					LCD.drawString("Jos ei, paina ESCAPE näppäintä", 0, 0);
					if (Button.ENTER.isDown()) {
						continue;
					}
					if (Button.ESCAPE.isDown()) {
						break;
					}

				}

				break;
			}

		}

	}
}
