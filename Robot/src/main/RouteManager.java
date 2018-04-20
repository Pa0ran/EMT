package main;

public class RouteManager {
	
	private int[] whatDo;
	private float[] time;
	public boolean Play = false;
	public RouteManager() {
		
	}
	
	public void Record(int what,float howLong) {
		int count = 0;
		whatDo[count] = what;
		time[count] = howLong;
		count++;
	}
	public void Play() {
		Play = true;
		float timeStart = System.nanoTime();
		for(int i = 0;i<time.length;i++) {
			if(whatDo[i] == 1) {
				
			}
			else if (whatDo[i] == 2) {
				
			}
			else if (whatDo[i] == 3) {
							
						}
			else if (whatDo[i] == 4) {
				
			}
			else if (whatDo[i] == 9) {
				
			}
		}
	}
}
