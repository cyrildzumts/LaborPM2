/**
 * 
 * @author Theophile Teyou Soh
 * HAW HAMBURG
 * TI PM2
 * WS 2015
 * 
 * @author Cyrille Ngassam Nkwenga
 * HAW HAMBURG
 * TI PM2
 * WS 2015
 * 
 * Abstrakt List Interface
 * Ziel : Eine einfache Interface für einen Container implementieren
 * 
 * Beschreibung : Manchmal wollen wir eine Liste von Objekten (nichts mit 
 * der Java-Object Klasse zu tun) in einem Ort speichern. Es kommt aber 
 * ofter vor dass wir nicht wissen wie viel Objekten wir speichern wollen.
 * z.b Es koennte eine Einkaufliste sein. Mann bereitet die Einkauflist zuhause vor,
 * aber  beim einkaufen fällt uns noch einpaar Sachen ein, die wir kaufen wollen.
 * In diesem Fall, wir tragen in der Liste ein, die neuen Sachen die gerade uns eingefallen 
 * sind.
 * 
 * Aber Es kann sein dass wir auch zuviel Sachen in der Liste eingetragen haben und
 * dann keinen Platz mehr haben daraus folgt dass wir nichts mehr eintragen können.
 * Ein Lösung wäre dann ein paar Sachen von der Liste entfernen, die wir nicht mehr 
 * mehr brauchen.
 * AbstracctList versucht genau solche Liste zu implementieren.
 * 
 */


package aufgabenblatt1;

@SuppressWarnings("unchecked")
public class ArrayListe<T extends Comparable<T>>{

	private Object[] container;
	private int anzahlElemente;
	
	private static final int INDEX_LOWER_BOUND = 1; 
	private static int DEFAULT_CAPACITY = 20  + INDEX_LOWER_BOUND;
	
	
	
	public ArrayListe() {
		this(DEFAULT_CAPACITY);
	}
	
	
	public ArrayListe(int arraySize){
		anzahlElemente = 0;
		container = new Object [arraySize + INDEX_LOWER_BOUND]; 
		System.out.println("ConcreteList created");
	}
	
	public void hinzufuegen(T item) throws IndexOutOfBoundsException{
		
		hinzufuegen(anzahlElemente , item);
		
	}
	public void hinzufuegen(int pos, T item) throws IndexOutOfBoundsException {
		
		checkIndex(pos + INDEX_LOWER_BOUND , anzahlElemente + 1 + INDEX_LOWER_BOUND);

		if(anzahlElemente == container.length -1){
			resize(container.length * 2);
		}
		for(int index = anzahlElemente ; index >= pos + INDEX_LOWER_BOUND; index--){
			container[index + 1] = container [index];
		}
		container[pos + INDEX_LOWER_BOUND] = item;
		anzahlElemente++;
	}

	public void entfernen(T item) throws IndexOutOfBoundsException{
		entfernenElementAtIndex(find(item));		
	}
	
	public void entfernenElementAtIndex(int pos) throws IndexOutOfBoundsException {
		checkIndex(pos + INDEX_LOWER_BOUND , anzahlElemente + 1 );
		for(int index = pos + INDEX_LOWER_BOUND; index < anzahlElemente ; index++){
			container[index ] = container[index + 1];
		}
		container[anzahlElemente] = null;
		anzahlElemente--;		
	}

	
	private int find(T item) {
		int i = anzahlElemente + 1;
		container[0] = item;
		while(container[i] != item){
			i--;
		}
		return (i - 1);
	}

	
	public T get(int pos) throws IndexOutOfBoundsException {
		checkIndex(pos + INDEX_LOWER_BOUND , anzahlElemente +1);
		return (T)container[pos + INDEX_LOWER_BOUND];
	}
	
	public int getAnzahlEmente() {
		
		return anzahlElemente;
	}

	protected void resize(int capacity) {
		Object[] tmp = new Object [capacity];
		for(int index = 0; index < anzahlElemente; index++){
			tmp[index] = (T)container[index];
		}
		container = tmp;
	}
	
	protected void checkIndex(int lowBound, int upperBound) throws IndexOutOfBoundsException  {
		if ((lowBound < INDEX_LOWER_BOUND)|| (lowBound >= upperBound)) {
			throw new IndexOutOfBoundsException("Index " + (lowBound - 1) + " is out of bound");
		}
	}
	
	@Override
	public String toString(){
		
		String info =  String.format("---------- " + this.getClass().getName() + "----------\n");;
		info += String.format("Anzahl Elemente : %d\n", anzahlElemente);
		info += String.format("Frei Blocke : %d\n", (container.length - anzahlElemente -1));
		info += "Inhalt Typ : " + get(0).getClass().getTypeName() + "\n";
		info += "----------------------------------------------------\n";
		
		return info;
	}
	public T getKleinstesElement(){
		int kleinsteIndex = 1;
		for (int index = 2; index <= anzahlElemente; index++){
			if (((T)container[kleinsteIndex]).compareTo((T)container[index]) == 1){
				kleinsteIndex = index;
			}
		}
		return (T)container[kleinsteIndex];
	}
	
	public static int summe(ArrayListe<Integer> list){
		
		int sum = 0;
		for(int index = 0; index < list.getAnzahlEmente(); index++){
			sum += list.get(index).intValue();
		}
		return sum;
	}
}