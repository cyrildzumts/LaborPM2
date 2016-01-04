package aufgabenblatt4;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PolygonModel extends Observable implements Observer{
	enum SIGNAL{
		NEW_POINT_ADDED, CURRENT_POL_IS_COMPLETED, NEW_POL_ADDED
	}
	private List<Polygon> polygons;
	private Polygon  currentPolygon;
	
	
	public PolygonModel()
	{
		polygons = new ArrayList<Polygon>();
		currentPolygon = new Polygon();
		currentPolygon.addObserver(this);
	}
	
	public PolygonModel(Polygon polygon)
	{
		polygons = new ArrayList<Polygon>();
		currentPolygon = polygon;
		currentPolygon.addObserver(this);
	}

	public List<Polygon> getPolygons() {
		return polygons;
	}

	public Polygon getCurrentPolygon() {
		return currentPolygon;
	}
	
	public void addPolygon(Polygon polygon){
		currentPolygon = polygon;
		currentPolygon.addObserver(this);
		setChanged();
		notifyObservers(SIGNAL.NEW_POL_ADDED);
	}
	public int size(){
		return polygons.size();
	}
	
	public void applyChanges(){
		if(currentPolygon != null){
			polygons.add(currentPolygon);
			setChanged();
			notifyObservers(currentPolygon.toString());
			addPolygon(new Polygon());
			
		}

		
	}

	@Override
	public void update(Observable o, Object point) {
		System.out.println("Model : Signal Received from Polygon Point : " + point);
		setChanged();
		notifyObservers(point);
		
	}

}
