package aufgabenblatt2;

import java.util.Arrays;

public class RennDemo {

	public static void main(String[] args) {
		RennAuto [] autos = new RennAuto [3];
//		ThreadAbbruch abbruchThread = new ThreadAbbruch(Arrays.asList(autos));
//		try {
//			abbruchThread.join();
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		long start = System.currentTimeMillis();
		for (int i = 0; i < autos.length; i++){
			autos[i] = new RennAuto();
		}
		//abbruchThread.start();
		for (RennAuto auto : autos){
			try {
				auto.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		double endeZeit  = ((double )(System.currentTimeMillis() )-start)*0.001;
		System.err.format("Runtime %.1f\n",endeZeit);
		System.err.println("Rennen zuende.\nErgebnis:");
		for(RennAuto auto : autos){
			if(!auto.isAlive()){
				System.err.println(auto);
			}
		}
		
		//abbruchThread.interrupt();

	}

}
