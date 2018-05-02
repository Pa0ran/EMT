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
			LCD.drawString("Hello", 0, 0);
			LCD.drawString("Mita saisi olla)", 0, 0);
			LCD.drawString("Tarjolla olisi mansikkajaateloa, suklaajaateloa ja lakritsijaateloa.", 0, 0);
			LCD.drawString("Jos haluat ostaa jaateloa paina Enter nappainta", 0, 0);
			LCD.clear();

			switch (i) {

			case 1:
				if (Button.ENTER.isDown()) {
					LCD.drawString("Jaatelo1", 0, 0);
					kassaSaldo = kassaSaldo + jaatelo1;

				} else if(Button.DOWN.isDown()){
					i++;
				}
				break;
			case 2:
				if (Button.ENTER.isDown()) {
					LCD.drawString("Jaatelo2", 0, 0);
					kassaSaldo = kassaSaldo + jaatelo2;

				} else if(Button.DOWN.isDown()){
					i++;
				}

				break;
			case 3:
				if (Button.ENTER.isDown()) {
					LCD.drawString("Jaatelo3", 0, 0);
					kassaSaldo = kassaSaldo + jaatelo3;

				} else if(Button.DOWN.isDown()){
					i++;
				}
				break;
			default:

					LCD.drawString("Tulisiko viela muuta?", 0, 0);
					LCD.drawString("Jos tulee, niin paina Enteria", 0, 0);
					LCD.drawString("Jos ei, paina ESCAPE nappainta", 0, 0);
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
