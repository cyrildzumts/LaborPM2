package aufgabenblatt4;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller extends Application{

	Button create;
	Button validate;
	private PolygonView view;
	private PolygonModel model;
	private Command command;
	//private ObservableList<String> strings;
	HBox topCorner;
	VBox rightCorner;
	
	private ListView<String> listView;
	private TextField textField;
	
	
	public Controller()
	{
		model = new PolygonModel();
		listView = new ListView<String>();
		view = new PolygonView(model,listView);
		command = new Command(model);
		validate = new Button("Eingabe");
		create = new Button("Seten / neu");
		
		listView.getItems().add("Nothing in The list");
		textField = new TextField();
		rightCorner = new VBox(10);
		topCorner = new HBox(new Label("Path Drawing"));
		rightCorner.getChildren().addAll(create, listView,textField, validate);
		view.setTop(topCorner);
		view.setRight(rightCorner);
		
		view.setMargin(rightCorner, new Insets(12,12,12,12));
		
		
		 
	}
	
	
	
	public void attachSignal()
	{
		create.setOnAction(e->view.addPolygon());
		validate.setOnAction(e->command.apply(textField.getText()));
	}
	
	public static void main(String []args){
		Application.launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		attachSignal();
		
		Scene scene = new Scene(view);
		stage.setScene(scene);
		stage.setTitle("Praktikum 4");
		stage.show();
		
	}

}
