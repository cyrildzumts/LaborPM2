package aufgabenblatt4;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Polygon extends Observable {
	
	private List<Point> points;
	
	public Polygon()
	{
		points = new ArrayList<Point>();
	}
	
	public Polygon(Point ...points)
	{
		this();
		addAll(points);	
	}

//	public void setPolygon(Polygon polygon){
//		points = new ArrayList<Point>(polygon.getPoints());
//		setChanged();
//		notifyObservers();
//	}
	
	public List<Point> getPoints() {
		return points;
	}
	
	void addPoint(Point point)
	{
		points.add(point);
		setChanged();
		notifyObservers(point);
	}
	
	void addAll(Point ...points)
	{
		for(Point point : points)
			this.points.add(point);
		setChanged();
		notifyObservers();
	}
	
	public int size(){
		return points.size();
	}
	public String toString()
	{
		return "Polygon with " + size()+ " Points";
	}
	
}
