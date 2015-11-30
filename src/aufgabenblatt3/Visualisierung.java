package aufgabenblatt3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

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
 * Description : This is Graphics Interface to our Simulation
 * 
 */
public class Visualisierung extends Application{
	
	private Simulation simulation; 
	private SimulationObserver updater ;
	private VBox gleisenBox;
	private HBox[] zuegeBox;
	private Scene scene;
	private Button start;
	private Button stop;
	private Button pause;
	private HBox buttons;
	Thread taskWorker;
	
	public Visualisierung(){
		simulation = new Simulation();
		zuegeBox = new HBox[simulation.getGleisenAnzahl()];
		updater = new SimulationObserver(simulation,zuegeBox);
		simulation.addObserver(updater);
		start = new Button("Start");
		stop = new Button("Stop");
		start.setStyle("-fx-base: #615C8D");
		stop.setStyle("-fx-base: #E84144");
		pause = new Button ("Pause");
		buttons = new HBox(20);
		buttons.getChildren().addAll(stop, start, pause);
		start.setOnAction(e ->{
			if(simulation.isSuspended()){
				simulation.setSuspended(false);
			}
			else
				updateTask();
		});
		
		stop.setOnAction(e->{
			simulation.interrupt();
			
		});
		pause.setOnAction(e ->{
			if(!simulation.isSuspended()){
				simulation.setSuspended(true);
			}
			else 
			{
				simulation.setSuspended(false);
			}
		});
		
		gleisenBox = new VBox(10);
		gleisenBox.setStyle("-fx-background-color: #403E6E");
		for(int i = 0; i < zuegeBox.length; i++){
			zuegeBox[i] = new  HBox(10);
			zuegeBox[i].getChildren().add(new Label("Gleis " + (i + 1 )));
			zuegeBox[i].setStyle("-fx-background-color: #FFFFFF");
			zuegeBox[i].setMinSize(30, 40);
			gleisenBox.getChildren().add(zuegeBox[i]);
		}
		gleisenBox.setPadding(new Insets(20));
		gleisenBox.getChildren().add(buttons);

		scene = new Scene(gleisenBox, 300, 600);
		
	}
	public static void main(String []args){
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setScene(scene);
		stage.setTitle("Rangiebahnhof");
		
		stage.show();
	}

	void updateTask(){
		taskWorker = new Thread(simulation);
		taskWorker.setDaemon(true);
		taskWorker.start();
	}
}
