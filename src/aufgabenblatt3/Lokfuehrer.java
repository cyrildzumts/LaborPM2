package aufgabenblatt3;

/**
 * @author Cyrille Ngassam Nkwenga
 * Theophile Teyou Soh
 * 
 * 
 * HAW HAMBURG
 * WS 2015
 * Programming Methodic 2
 * Prof : Herr Phillip Jenke
 * TI B2
 * 
 * Description : A Lokfuehrer drives a train in the 
 * Main Station out  the train out of the Main Station
 * An Instance of this class has only one Task : drive in or out.
 * After he has done the job, it then quit.
 *  
 */
public class Lokfuehrer extends Thread {
	
	public enum FarhtRichtung{
		EINFAHRT, AUSFAHRT
	}
	private RangierBahnhof hbf;
	/**
	 * the gate index 
	 */
	private int gleis;
	/**
	 * richtung defines what the driver should do 
	 */
	private FarhtRichtung richtung;
	
	public Lokfuehrer(RangierBahnhof hbf, int gleis, FarhtRichtung richtung){
		this.hbf = hbf;
		this.gleis = gleis;
		this.richtung = richtung;
		start();
	}
	
	public void run(){
		
		switch (richtung) {
		case EINFAHRT:
			hbf.einfahren(new Zug(Zug.Typ.METRONOM), gleis);
			break;
			
		case AUSFAHRT:
			hbf.ausfahren(gleis);
			break;
		}
	}
}
