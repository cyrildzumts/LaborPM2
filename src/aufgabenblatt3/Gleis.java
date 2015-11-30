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
 * Description : A Gleis always knows if it has a Train or not
 * It also knows its gate number is. 
 *  
 */

public class Gleis {
	private Zug zug;
	private int gleisNummer;

	public Gleis(){
		this(null);
	}
	
	public Gleis(Zug zug){
		this.setZug(zug);
	}

	/**
	 * 
	 * @return true if the Gate the free or false when not.
	 */
	public boolean isGleisLeer()
	{
		return zug == null;
	}
	/**
	 * 
	 * @return a reference to the train which is currently on this Gate
	 */
	public Zug getZug() {
		return zug;
	}

	/**
	 * 
	 * @param zug Set The Train which is currently on this Gate
	 */
	public void setZug(Zug zug) {
		this.zug = zug;
	}

	/**
	 * 
	 * @return The Gate number
	 */
	public int getGleisNummer() {
		return gleisNummer;
	}

	/**
	 * 
	 * @param gleisNummer Defines the Gate's number
	 */
	public void setGleisNummer(int gleisNummer) {
		this.gleisNummer = gleisNummer;
	}
	
	public String toString(){
		return String.format("Gleis : %d\nZug : %s", gleisNummer, zug);
	}
	
}
