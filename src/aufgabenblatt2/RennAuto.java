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
 * Description : RennAuto is a derived Class from Thread so that 
 * we could run many Auto concurrently.
 * 
 * In this class we simulate an auto run course. Every Auto
 * has a  to drive over a defined distance. The speed at which 
 * each auto move is random. At the end each auto saves the time
 * needed to finish the course. It is also possible to ask an auto
 * to interrupt the course.
 * 
 */

public class RennAuto extends Thread{
	/**
	 * the total distance 
	 */
	private double rennStrecke;
	/**
	 * the already achieved distance
	 */
	private double strecke;
	private static int autoCounter = 0;
	/**
	 * The Auto number
	 */
	private int wagenNummer;
	/**
	 * The time needed to cover the total distance 
	 */
	private double endeZeit;
	
	/**
	 * 
	 * @param rennStrecke the used defined total distance to cover
	 * after each Auto is created, it start to run.
	 */
	public RennAuto(double rennStrecke){
		this.rennStrecke = rennStrecke;
		strecke = 0;
		wagenNummer = autoCounter;
		autoCounter++;
		start();
	}
	
	/**
	 * we start with default total distance of 10m
	 */
	public RennAuto(){
		this(10.0);
	}
	
	/**
	 * This is the code to run by the Thread 
	 * Every Auto drives at a speed between m/0.8s and m/1.2s
	 * the Speeds is calculated randomly.
	 * The auto drive until it reaches the end or it receives an interrupt
	 * signal.
	 * 
	 */
	public void fahren(){
		double time ;
		long start = System.currentTimeMillis();
		while(Double.compare(strecke, rennStrecke) != 0){
			if(!isInterrupted()){
				time = 0.8 + (Math.random() * ((1.2 - 0.8) + 0.04));
				try {
					Thread.sleep((long) (time* 1000));
				} catch (InterruptedException e) {
					//e.printStackTrace();
					System.err.printf("Wagen %d  Interrupt caught.\n", wagenNummer);
					interrupt();
				}
				strecke ++;
				System.err.printf("Wagen %d : %.1f / %.1f\n",wagenNummer, strecke, rennStrecke);
			
				}
			else{
					break;
				}
			}
		endeZeit  = ((double )(System.currentTimeMillis() )-start)*0.001;
	}
	
	public void run(){
		fahren();
	}

	/**
	 * returns as a String an information about this Auto. Actually it returns the time needed by this Auto 
	 * to cover the total distance.
	 */
	public String toString(){
		return String.format("Wagen %d : %.1f\n", wagenNummer,endeZeit);
	}
}
