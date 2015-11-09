package aufgabenblatt2;

/**
 * @author Cyrille Ngassam Nkwenga
 * 
 * 
 * HAW HAMBURG
 * WS 2015
 * Programming Methodic 2
 * Prof : Herr Phillip Jenke
 * TI B2
 * 
 * Description : ThreadAbbruch is a derived Class from Thread.
 * 
 * In this class allows to ask a RennAuto to stop driving.
 * It saves in this case a list of RennAutos and then randomly dispatches
 * every second an Interrupt signal to a RennAuto. 
 * 
 */
import java.util.List;

public class ThreadAbbruch extends Thread {
	/**
	 * List of auto to send the interrupt signal
	 */
	private List<RennAuto> autos;
	
	public ThreadAbbruch(List<RennAuto> autos){
		this.autos = autos;
	}
	/**
	 * As long as it is not interrupted, it send every second
	 * an interrupt signal to an auto.
	 */
	public void run(){
		while ( !isInterrupted()){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				//e.printStackTrace();
				System.err.println("Abbruch gefangen");
				interrupt(); // marks the set the Interrupt Flag. 

			}
			int index =  (int)(Math.random() * (autos.size()));
			autos.get(index).interrupt();
			
		}
	}

}
