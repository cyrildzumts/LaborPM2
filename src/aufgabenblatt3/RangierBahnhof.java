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
 * Description : RangierBahnhof represents the Train's station
 * A train can get in or get out.
 */
public class RangierBahnhof {

	/**
	 * List of Gate available on this Train Station
	 */
	private Gleis[] gleisen;
	/**
	 * A Flag to define whether a gateway is free or not
	 */
	private volatile boolean isWegFrei;

	public RangierBahnhof() {
		this(10);
	}

	public RangierBahnhof(int gleisAnzahl) {
		gleisen = new Gleis[gleisAnzahl];
		isWegFrei = true;
		for (int i = 0; i < gleisAnzahl; i++) {
			gleisen[i] = new Gleis();
			gleisen[i].setGleisNummer(i);
		}

	}

	/**
	 * This Method returns the gate defined by the index gleis
	 * @param gleis the index of the Gleis in the Main station
	 * @return the Gate which corresponds to the index
	 * @throws IndexOutOfBoundsException  An IndexOutOfBoundsException is thrown when the 
	 * index gleis isn't valid
	 */
	public Gleis getGleis(int gleis) throws IndexOutOfBoundsException {
		if (gleis < 0 || gleis >= gleisen.length) {
			throw new IndexOutOfBoundsException("gleis : " + gleis
					+ " when Gleisen length is : " + gleisen.length);
		}
		return gleisen[gleis];
	}

	/**
	 * 
	 * @return The number Gleis available from this Train Station
	 */
	public int getGleisAnzahl() {
		return gleisen.length;
	}

	/**
	 * 
	 * @param gleis The index of the Gate to be checked
	 * @return True if The Gate is free or False when not
	 * @throws IndexOutOfBoundsException Is thrown when the index gleis 
	 * invalid
	 */
	public boolean isGleisLeer(int gleis) throws IndexOutOfBoundsException {
		if (gleis < 0 || gleis >= gleisen.length) {
			throw new IndexOutOfBoundsException("gleis : " + gleis
					+ " when Gleisen length is : " + gleisen.length);
		}
		return gleisen[gleis].isGleisLeer();
	}

	/**
	 * 
	 * @param zug Set this zug on the Gate defined the index gleis
	 * @param gleis the index of the gate to set the train on.
	 * @throws IndexOutOfBoundsException Is thrown when the index gleis 
	 * invalid
	 */
	public synchronized void einfahren(Zug zug, int gleis)
			throws IndexOutOfBoundsException {
		while (!isWegFrei) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// e.printStackTrace();
			}
		}

		isWegFrei = false;
		if (isGleisLeer(gleis)) {
			gleisen[gleis].setZug(zug);
			System.err.println("Zug ist eingefahren in Gleis : " +  gleis);
		} else{
			System.err.println("Zug kann nicht einfahren : Gleis ist besetzt : "  + gleis);
		}
			
		isWegFrei = true;
		this.notifyAll();
	}

	/**
	 * Set a Gate defined by index gleis free
	 * @param gleis the index of the gate to set free
	 * @throws IndexOutOfBoundsException Is thrown when the index gleis 
	 * invalid
	 */
	public synchronized void ausfahren(int gleis)
			throws IndexOutOfBoundsException {
		
		while (!isWegFrei) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isWegFrei = false;
		if(!isGleisLeer(gleis))
		{
			System.err.println("Zug ist ausgefahren vom Gleis : " + gleis);
			gleisen[gleis].setZug(null);
		}
		else{
			System.err.println("Zug kann nicht ausfahren : Gleis  "  + gleis + " ist leer");
		}
		isWegFrei = true;
		this.notifyAll();
	}
}
