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
 * Description : This Class represents a Train. 
 * A train can present itself
 */
public class Zug{
	
	public enum Typ {
		 ICE, SBAHN, METRONOM
		}
	private Typ typ;
	
	public Zug(){
		this(Typ.SBAHN);
	}
	public Zug(Typ typ){
		this.setTyp(typ);
	}
	/**
	 * 
	 * @return The train's typ
	 */
	public Typ getTyp() {
		return typ;
	}
	/**
	 * 
	 * @param typ the of the train to be set
	 */
	public void setTyp(Typ typ) {
		this.typ = typ;
	}
	
	public String toString()
	{
		return String.format("Zug Typ :%s", typ.toString());
		
	}
}


