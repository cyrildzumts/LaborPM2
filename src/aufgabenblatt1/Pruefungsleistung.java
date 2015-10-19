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
	
	
	public Pruefungsleistung(String module, double note){
		if(!module.isEmpty()){
			this.module = module;
			this.note = note;
		}
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
