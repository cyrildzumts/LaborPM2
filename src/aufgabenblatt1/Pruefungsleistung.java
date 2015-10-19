package aufgabenblatt1;

public class Pruefungsleistung {

	
	/**
	 *  Name des Modules
	 */
	private String module;
	
	/**
	 * Note die der Student fuer dieses Module
	 * bekommen hat
	 */
	private double note;
	
<<<<<<< HEAD
	
	public Pruefungsleistung(String module, double note){
		if(!module.isEmpty()){
			this.module = module;
			this.note = note;
		}
=======
	public Pruefungsleistung(String module, double note){
		this.module = module;
		this.note = note;
>>>>>>> 0552985649d89be8da5a1c08e3ec050cb393e51d
	}
	
	/** 
	 * @return Liefert den Modulename zurueck
	 */
	public String getModule(){
		return module;
	}
	
	/**
	 * @return Liefert die Note dieses Modules zurueck
	 */
	public double getNote(){
		return note;
<<<<<<< HEAD
		
=======
>>>>>>> 0552985649d89be8da5a1c08e3ec050cb393e51d
	}
	
	public void setModule(String module){
		if(!module.isEmpty()){
			this.module = module;
		}
	}
	
	public void setNote(double note){
		this.note = note;
	}
}
