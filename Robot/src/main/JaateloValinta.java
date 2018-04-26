




import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

public class JaateloValinta {
	double jaatelo1;
	double jaatelo2;
	double jaatelo3;
	double kassaSaldo;
	
	public JaateloValinta(double jaatelo1, double jaatelo2, double jaatelo3, double kassaSaldo){
		this.jaatelo1 = 2.50;
		this.jaatelo2 = 3.25;
		this.jaatelo3 = 1.50;
		this.kassaSaldo = 10.50;
		
		String jaatelot[] = {"Mansikkajäätelo", "Suklaajäätelö", "Lakritsijäätelö"};
		
		for(int i=0; i< jaatelot.length; i++){
			
			LCD.drawString("Päivää",0,0);
			LCD.drawString("Mitä saisi olla?",0,0);
			LCD.drawString("Tarjolla olisi mansikkajäätelöä, suklaajäätelöa ja lakritsijäätelöä.",0,0);
		    LCD.drawString("Jos haluat ostaa jäätelöä paina Enter näppäintä",0,0);
		     
		    if(Button.ENTER.isDown()) {
			
			  while(!Button.ESCAPE.isDown()) {
			    	
			    	if(Button.LEFT.isDown()) {
			    		kassaSaldo = kassaSaldo + jaatelo1;
			    	}else if(Button.RIGHT.isDown()) {
			    		kassaSaldo = kassaSaldo + jaatelo2;
			    	}else if(Button.DOWN.isDown()) {
			    		kassaSaldo = kassaSaldo +jaatelo3;    	
			        }else if(Button.UP.isDown()) {
			        	LCD.drawString("Do you want to buy more ice cream?",0,0);
			        	LCD.drawString("If you do, press button ENTER",0,0);
			        	LCD.drawString("If you want to quit, press ESCAPE button",0,0);
			        	if(Button.ENTER.isDown()) {
			        		continue;
			         	}if(Button.ESCAPE.isDown()) {
			         		break;
			         	}
			        		
			        }
			    	
			    		LCD.drawString("Kassan saldo:"+kassaSaldo,0,0);
			    	
			    	
			    }
		    }
		
		for(String menu: jaatelot) {
			
			
			
		}
		

	
	}}}
	
	
	


	
	

