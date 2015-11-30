package aufgabenblatt3;

import java.util.Observable;

import aufgabenblatt3.Lokfuehrer.FarhtRichtung;
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
 * Description : Simulation simulates how trains drive in and out the Main Station
 * The choice of the task is randomly choosen. On the same choosing a gate is randomly
 * done too.
 * 
 */

public class Simulation extends Observable implements Runnable {

	/**
	 * hbf represents  The Main Station
	 * 
	 */
	private RangierBahnhof hbf;
	/**
	 * isInterrupted  is a Flag which helps us
	 * to control the simulation.
	 * When set, the simulation stops.
	 */
	private volatile boolean isInterrupted;
	/**
	 * suspended  is a Flag which helps us
	 * to control the simulation.
	 * When set, the simulation is suspended.
	 */
	private volatile boolean suspended;

	/**
	 * The index of a gate 
	 */
	private int gleis;
	
	
	public Simulation() {
		hbf = new RangierBahnhof();
		isInterrupted = false;
		suspended = false;
	}
	
	/**
	 * 
	 * @return true if the task is suspended
	 */
	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
		notify();
	}
	/**
	 * 
	 * @param gleis the index of the gate we are interrested in
	 * @return the Gate corresponding to the index gleis
	 */
	public Gleis getGleis(int gleis){
		try{
			return hbf.getGleis(gleis);
		}
		catch(IndexOutOfBoundsException error){
			error.printStackTrace();
			return null;
		}
	}
	/**
	 * Interrupt this task.
	 */
	public void interrupt(){
		if(!isInterrupted){
			isInterrupted = true;
		}
	}
	/**
	 * 
	 * @return the number of Gate available on hbf
	 */
	public int getGleisenAnzahl(){
		return hbf.getGleisAnzahl();
	}
	@Override
	public void run() {
		while (!isInterrupted) {
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				isInterrupted = true;
			}
			gleis = ((int) (Math.random() * hbf.getGleisAnzahl()) );
			if (((int) (Math.random() * 10)) % 2 == 0) {
				
				try{
					new Lokfuehrer(hbf, gleis,FarhtRichtung.EINFAHRT);
					setChanged();
					//hasChanged();	
				}
				catch(IndexOutOfBoundsException error){
					error.printStackTrace();
				}
				
			}
			else{
				try{
					new Lokfuehrer(hbf, gleis,FarhtRichtung.AUSFAHRT);
					setChanged();
					//hasChanged();	
				}
				catch(IndexOutOfBoundsException error){
					error.printStackTrace();
				}
			}
			notifyObservers(getGleis(gleis));
			while(suspended){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();

				}
			}
		}
	}

}
