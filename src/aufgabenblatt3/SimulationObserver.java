package aufgabenblatt3;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Platform;
import javafx.scene.layout.HBox;

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
 * Description : SimulationObserver observes an Simulation 
 * reacts on any changes that may appear on the Simulation
 * 
 */
public class SimulationObserver implements Observer{

	/**
	 * The observee
	 */
	private Simulation simulation;
	/**
	 * A link to the Items we want to update 
	 * when simulation has changed.
	 */
	private HBox [] zuegeBox;
	
	public SimulationObserver(Simulation simulation,HBox [] boxes) {
		this.simulation = simulation;
		this.simulation.addObserver(this);
		zuegeBox = boxes;
	}
	/**
	 * 
	 * @param boxes the list of item to update
	 */
	public void setBoxArray(HBox [] boxes){
		zuegeBox = boxes;
	}
	@Override
		public void update(Observable o, Object arg) {
			Gleis gleis = (Gleis)arg;
			System.err.println("Simulation updated");
			if(gleis != null){
				if(gleis.getZug() == null){
				    Platform.runLater(()->
				    	zuegeBox[gleis.getGleisNummer()].setStyle("-fx-background-color: #FFFFFF")); 
				    
				}
				else{
					Platform.runLater( ()-> zuegeBox[gleis.getGleisNummer()].setStyle("-fx-background-color: #615C8D") );
				}
			}
		
	}

}
