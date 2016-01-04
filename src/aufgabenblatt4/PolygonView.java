package aufgabenblatt4;

import java.util.Observable;
import java.util.Observer;

import aufgabenblatt4.PolygonModel.SIGNAL;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class PolygonView extends BorderPane implements  Observer{

	private final PolygonModel model;
	private Command command;
	HBox center;
	private Path currentpath;
	private Point lastPoint;
	private Label title;
	private ListView<String> listView;
	
	
	public PolygonView(PolygonModel model, ListView<String> listView) {
		this.model = model;
		model.addObserver(this);
		currentpath = new Path();

		
		lastPoint = null;
		title = new Label("PolygonView");
		this.setTop(title);
		this.setPrefSize(700.0, 800.0);
		this.listView = listView;
	}
	
	public void setCommand(Command command)
	{
		this.command = command;
	}
	@Override
	public void update(Observable o, Object arg) {
		// if it is a point, then we simply continue 
		// to draw the path.
		if(arg instanceof Point)
		{
			Point point = (Point) arg;
			if(lastPoint == null)
			{   currentpath = new Path();
				this.getChildren().add(currentpath);
				currentpath.setStroke(Color.CYAN);
				currentpath.getElements().add(new MoveTo(point.getX(), point.getY()));
			}
			else
			{
				currentpath.getElements().add(new LineTo(point.getX(), point.getY()));
				
			}
			lastPoint = point;
			
			this.getChildren().add(new Ellipse( point.getX(), point.getY(), 5.0, 5.0));
		}
		// 
		else if (arg instanceof String)
		{
			String signal = (String)arg;
			currentpath.setStroke(Color.BLACK);
			listView.getItems().add(signal);
			lastPoint = null;
		}
		else
			{
				//currentpath = new Path();
				lastPoint = null;
				
			}
	}
	
	public void addPoint(Point point)
	{
		System.out.println("Signal Received : Add point Point");
		model.getCurrentPolygon().addPoint(point);
	}
	public void addPoint(double x, double y)
	{
		System.out.println("Signal Received : Add point x: " + x + " , y :  " +y);
		model.getCurrentPolygon().addPoint(new Point(x, y));
	}
	
	public void addPolygon(){
		System.out.println("Signal Received : Add Polygon");
		model.applyChanges();
	}
}
